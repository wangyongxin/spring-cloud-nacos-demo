package com.wangyx.controller;

import com.wangyx.service1.api.ConsumerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    //注入service 基于dubbo协议
    @Reference
    private ConsumerService consumerService;

    @GetMapping("/echo/{message}")
    // 特别地，若 blockHandler 和 fallback 都进行了配置，则被限流降级而抛出 BlockException 时只会进入 blockHandler 处理逻辑。若未配置 blockHandler、fallback
    // 和 defaultFallback，则被限流降级时会将 BlockException 直接抛出。
    // @SentinelResource(value = "consumer-echo", blockHandler = "exceptionHandler", fallback = "echoFallBack")
//    @SentinelResource(value = "consumer-echo", fallback = "echoFallBack")
    public String echo(@PathVariable("message")String message){
        return consumerService.echo(message);
    }

//    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数
//    public String echoFallBack(String message) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return "[echoFallBack] Dubbo Sentinel Nacos Consumer:  - fallback " + df.format(new Date());
//    }
//
//    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
//    public String exceptionHandler(String message, BlockException ex) {
//        ex.printStackTrace();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return "[exceptionHandler] Dubbo Sentinel Nacos Consumer:  - exception exMessage[" + ex.getMessage() + "]" + df
//                .format(new Date());
//    }
}
