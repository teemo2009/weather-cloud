package com.weather.service;

import com.weather.vo.Weather;

public interface WeatherReportService {

    public Weather getDataByCityId(String cityId);

}
