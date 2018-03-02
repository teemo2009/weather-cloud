package com.weather.controller;

import com.weather.service.CityDataService;
import com.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Value("${server.port}")
    String port;

    @Autowired
    CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception {
        System.out.println("port="+port);
        return cityDataService.listCity();
    }

}
