package com.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.service.WeatherDataService;
import com.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
          //缓存没有抛出异常
            throw  new RuntimeException("Don't has data");
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            resp = mapper.readValue(result, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
