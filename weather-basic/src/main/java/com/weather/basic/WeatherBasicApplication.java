package com.weather.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherBasicApplication.class, args);
    }
}
