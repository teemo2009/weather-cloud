package com.weather.controller;

import com.weather.service.WeatherDataService;
import com.weather.vo.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Resource
    private WeatherDataService weatherDataService;


    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
      return weatherDataService.getDataByCityName(cityName);
    }

}
