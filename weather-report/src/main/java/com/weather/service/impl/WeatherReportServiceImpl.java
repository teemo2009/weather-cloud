package com.weather.service.impl;

import com.weather.service.WeatherDataClient;
import com.weather.service.WeatherReportService;
import com.weather.vo.Forecast;
import com.weather.vo.Weather;
import com.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weatherResponse=weatherDataClient.getWeatherByCityId(cityId);
        Weather weather=weatherResponse.getData();
        return weather;
    }
}
