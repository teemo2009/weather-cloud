package com.weather.basic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.basic.service.WeatherDataService;
import com.weather.basic.util.OKHttpUtil;
import com.weather.basic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

  /*  @Autowired
    private RedisTemplate<String,String> stringRedisTemplate;*/

    @Resource
    private OKHttpUtil okHttpUtil;

    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeahter(uri);
    }

    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeahter(uri);
    }



    private WeatherResponse doGetWeahter(String uri) {
        String result=null;
        WeatherResponse resp = null;
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(uri)){
                result=ops.get(uri);
                System.out.println("redis has data");
        }else{
             result=okHttpUtil.httpGet(uri);
             //30分钟后超时
             ops.set(uri,result,30L, TimeUnit.MINUTES);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp = mapper.readValue(result, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri){
        String result=null;
        WeatherResponse resp = null;
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        result=okHttpUtil.httpGet(uri);
        //30分钟后超时
        ops.set(uri,result,30L, TimeUnit.MINUTES);
    }
}
