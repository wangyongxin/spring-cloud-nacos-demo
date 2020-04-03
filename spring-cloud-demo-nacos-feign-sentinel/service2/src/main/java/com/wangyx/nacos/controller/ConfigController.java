package com.wangyx.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${common.name}")
    private String config;

    @GetMapping(value = "/configs")
    public String getConfigs(){
        return config;
    }
}
