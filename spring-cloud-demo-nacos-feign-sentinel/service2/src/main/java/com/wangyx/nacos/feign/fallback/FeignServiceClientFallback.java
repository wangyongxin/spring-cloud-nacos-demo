package com.wangyx.nacos.feign.fallback;

import com.wangyx.nacos.feign.FeignServiceClient;
import com.wangyx.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class FeignServiceClientFallback implements FeignServiceClient {

    public String service() {
        return "网络不好，请重试";
    }

    public User user(String string) {
        return null;
    }
}
