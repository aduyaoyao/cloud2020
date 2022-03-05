package com.atguigu.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
//    @LoadBalanced 关闭Ribbon的负载均衡
    @Bean //方法名作为组件的id，返回类型就是组件类型
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
