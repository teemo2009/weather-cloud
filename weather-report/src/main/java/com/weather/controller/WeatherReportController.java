package com.weather.controller;

import com.weather.service.DataClient;
import com.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/report")
public class WeatherReportController {

/*    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityClient cityClient;*/

    //使用了网关代理
    @Autowired
    private DataClient dataClient;


    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", dataClient.listCity());
        model.addAttribute("report", dataClient.getDataByCityId(cityId).getData());
        return new ModelAndView("weather/report", "reportModel", model);

    }

    private List<City> getCityList(){
        List<City> cityList=null;
        try {
            cityList=new ArrayList<>();
            City city=new City();
            city.setCityName("深圳");
            city.setCityId("101280601");
            cityList.add(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  cityList;
    }

}
