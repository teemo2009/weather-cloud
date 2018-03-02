package com.weather.service;

import com.weather.vo.City;
import com.weather.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("weather-eureka-client-zuul")
public interface DataClient {

    @GetMapping("/city/cities")
    public List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityId/{cityId}")
    public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}
