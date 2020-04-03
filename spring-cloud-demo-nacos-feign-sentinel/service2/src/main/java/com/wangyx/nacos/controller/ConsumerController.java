package com.wangyx.nacos.controller;

import com.wangyx.nacos.feign.FeignServiceClient;
import com.wangyx.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeignServiceClient feignServiceClient;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        System.out.println("str=" + str);
        return restTemplate.getForObject("http://service1/echo/" + str, String.class);
    }
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User user(@PathVariable String name) {
        System.out.println("name=" + name);
        return restTemplate.getForObject("http://service1/user/" + name, User.class);
    }
    @RequestMapping(value = "/feign/consumer/{name}", method = RequestMethod.GET)
    public String feign_consumer(@PathVariable String name) {
        System.out.println("consumer name=" + name);
        return "consumer invoke | " + feignServiceClient.service();
    }

    @RequestMapping(value = "/feign/user/{name}", method = RequestMethod.GET)
    public User feign_user(@PathVariable String name) {
        System.out.println("feign name=" + name);
        return feignServiceClient.user(name);
    }
}
