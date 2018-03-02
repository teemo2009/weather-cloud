package com.weather.service;


/**
 * 数据采集接口
 * **/
public interface WeatherDataCollectionService {
    /**
     * 根据城市ID同步天气
     * */
    void sysncDataByCityId(String cityId);
}
