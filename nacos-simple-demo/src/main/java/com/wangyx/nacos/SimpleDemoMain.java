package com.wangyx.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class SimpleDemoMain {

    public static void main(String[] args) throws NacosException {
//        test1();
        test2();

    }

    private static void test1() throws NacosException {
        //nacos 地址
        String serverAddr = "127.0.0.1:8848";
        //String dataId = "nacos-simple-demo.yaml";
        String dataId = "nacos-simple-demo.yaml";
        //Group
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);

        ConfigService configService = NacosFactory.createConfigService(properties);
        //获取配置 String dataId, String group, long timeoutMs
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
    }
    //带命名空间 及 用户名密码
    private static void test2() throws NacosException {
        //nacos 地址
        String serverAddr = "127.0.0.1:8848";
        //String dataId = "nacos-simple-demo.yaml";
        String dataId = "nacos-simple-demo.yaml";
        String namespace = "d91431c4-c2bd-4186-b029-1f5817c4d764";//dev
        //Group
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        properties.put("namespace", namespace);
//        properties.put("username", "test");
//        properties.put("password", "123456");

        ConfigService configService = NacosFactory.createConfigService(properties);
        //获取配置 String dataId, String group, long timeoutMs
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
    }
}
