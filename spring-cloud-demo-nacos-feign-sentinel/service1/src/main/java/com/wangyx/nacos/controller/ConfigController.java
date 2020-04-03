package com.wangyx.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//启用配置自动刷新
@RefreshScope
public class ConfigController {

    //    @Autowired
//    ConfigurableApplicationContext applicationContext;

    @Value("${common.name:null}")
    private String commonName;
    @Value("${a.b:null}")
    private String ab;
    @Value("${a.c:}")
    private String ac;

    @GetMapping(value = "/configs")
    public String getCommonName(){
        return commonName;
        //笨办法
//        return applicationContext.getEnvironment().getProperty("common.name");
    }

    @GetMapping(value = "/ab")
    public String getAb(){
        return ab;
    }
    @GetMapping(value = "/ac")
    public String getAc(){
        return ac;
    }
}
