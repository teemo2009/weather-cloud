package com.weather.job;

import com.weather.service.CityClient;
import com.weather.service.WeatherDataCollectionService;
import com.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;


@Component
public class ScheduleJobs {
    private static final Logger log = LoggerFactory.getLogger(ScheduleJobs.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Resource
    private CityClient cityClient;

    @Resource
    private WeatherDataCollectionService weatherDataCollectionService;

    @Scheduled(fixedRate = 1800*1000)
    public void reportCurrentTime() {
        //获取城市ID列表
        System.out.println("天气同步开始！");
        List<City> cityList=null;
        try {
            cityList=cityClient.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //遍历城市ID获取天气
        for(City city:cityList){
            String cityId=city.getCityId();
            weatherDataCollectionService.sysncDataByCityId(cityId);
        }
        System.out.println("天气同步完毕！");
    }
}
