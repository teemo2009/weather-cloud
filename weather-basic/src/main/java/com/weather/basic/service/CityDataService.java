package com.weather.basic.service;

import com.weather.basic.vo.City;

import java.util.List;

public interface CityDataService {

    List<City> listCity() throws Exception;
}
