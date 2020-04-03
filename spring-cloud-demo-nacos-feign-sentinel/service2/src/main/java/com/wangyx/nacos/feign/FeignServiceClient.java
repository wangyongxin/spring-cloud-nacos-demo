package com.wangyx.nacos.feign;

import com.wangyx.nacos.feign.fallback.FeignServiceClientFallback;
import com.wangyx.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service1", fallback = FeignServiceClientFallback.class)// nacos中服务名
public interface FeignServiceClient {

    @GetMapping("/service")
    public String service();

    @RequestMapping(value = "/user/{string}", method = RequestMethod.GET)
    public User user(@PathVariable(value = "string") String string);

}
