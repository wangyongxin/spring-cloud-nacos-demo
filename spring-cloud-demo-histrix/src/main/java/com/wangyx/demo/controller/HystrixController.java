package com.wangyx.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.wangyx.demo.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

@RestController
public class HystrixController {

    @Resource
    private StoreService storeService;

    //http://localhost:8080/hello
    //hystix 功能1 fallback
    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "hystrixHello")
    public String hello(){
        throw new RuntimeException("xxx");
    }

    public String hystrixHello(){
        return "hystrix hello world;";
    }

    //hystix 功能2 合并请求，合并单位时间内的请求
    @GetMapping("/list")
    public List<Integer> list() throws Exception {
        //开启上下文ThreadLocal
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        Future<Integer> store1 = storeService.getStoreById(new Random().nextLong());
        Thread.sleep(900);//小于1秒内 会合并 1秒内的所有请求
        Future<Integer> store2 = storeService.getStoreById(new Random().nextLong());

        List<Integer> stores = new ArrayList<Integer>();
        stores.add(store1.get());
        stores.add(store2.get());
        return stores;
    }
}
