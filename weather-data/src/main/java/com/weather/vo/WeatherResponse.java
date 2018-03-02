package com.weather.vo;

import java.io.Serializable;

public class WeatherResponse implements Serializable {
    private Weather data;
    private Integer status;
    private String desc;



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }
}
