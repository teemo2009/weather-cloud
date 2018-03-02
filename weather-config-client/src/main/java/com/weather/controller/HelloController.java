package com.weather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {


    @Value("${author}")
    private String author;

    @GetMapping("/hello")
    public String hello(){
        return "hello  "+author;
    }

}
