package com.weather.basic.controller;

import com.weather.basic.service.WeatherDataService;
import com.weather.basic.util.OKHttpUtil;
import com.weather.basic.vo.WeatherResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Resource
    private WeatherDataService weatherDataService;

    @Resource
    private OKHttpUtil okHttpUtil;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
      return weatherDataService.getDataByCityName(cityName);
    }

}
