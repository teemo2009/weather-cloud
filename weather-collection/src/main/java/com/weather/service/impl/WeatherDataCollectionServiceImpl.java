package com.weather.service.impl;

import com.weather.service.WeatherDataCollectionService;
import com.weather.util.OKHttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private OKHttpUtil okHttpUtil;

    @Override
    public void sysncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri){
        String result=null;
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        result=okHttpUtil.httpGet(uri);
        //30分钟后超时
        ops.set(uri,result,30L, TimeUnit.MINUTES);
    }
}
