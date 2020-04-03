package com.wangyx.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

@Service
public class StoreService {

    Logger logger = LoggerFactory.getLogger(StoreService.class);

    //合并方法getStoreById请求到方法getStoreList，参数延迟合并1秒内的请求
    @HystrixCollapser(batchMethod = "getStoreList",
            collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")})
    public Future<Integer> getStoreById(Long id){
        return null;
    }

    @HystrixCommand
    public List<Integer> getStoreList(List<Long> id){
        logger.info("合并请求调用 入参集合数量 " + id.size());
        List<Integer> result = new ArrayList<Integer>();
        for(Long i : id){
            int e = new Random().nextInt();
            logger.info("合并请求调用 输出 " + e);
            result.add(e);
        }
        return result;
    }
}
