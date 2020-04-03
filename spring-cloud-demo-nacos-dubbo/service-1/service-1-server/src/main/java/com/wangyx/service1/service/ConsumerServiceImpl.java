package com.wangyx.service1.service;

import com.wangyx.service1.api.ConsumerService;

@org.apache.dubbo.config.annotation.Service  //注解标记此类的方法暴露为dubbo接口
public class ConsumerServiceImpl implements ConsumerService {

    //dubbo接口实现内容
    public String echo(String str) {
        return "dubbo service provider | echo str = " + str;
    }
}
