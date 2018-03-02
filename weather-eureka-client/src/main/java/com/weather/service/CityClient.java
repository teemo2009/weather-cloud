package com.weather.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
