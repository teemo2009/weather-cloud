package com.weather.service.impl;

import com.weather.service.CityDataService;
import com.weather.util.XmlBuilder;
import com.weather.vo.City;
import com.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        //读取xml文件
        Resource resource=new ClassPathResource("citylist.xml");
        BufferedReader bf=new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer=new StringBuffer();
        String line="";
        while ((line=bf.readLine())!=null){
            buffer.append(line);
        }
        bf.close();
        CityList cityList= (CityList) XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        //XML转化为java对象
        return cityList.getCityList();
    }
}
