package com.wangyx.nacos.controller;

import com.wangyx.test.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @RequestMapping(value = "/user/{string}", method = RequestMethod.GET)
    public User user(@PathVariable String string) {
        User user = new User();
        user.setName(string);
        user.setAge(18);
        System.out.println("user name:" + string);
        return user;
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String service() {
        return "service provider";
    }
}
