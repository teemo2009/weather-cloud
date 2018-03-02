package com.weather.basic.service;

import com.weather.basic.vo.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);


    /**
     * 根据城市ID同步天气
     * */
    void syncDateByCityId(String cityId);
}
