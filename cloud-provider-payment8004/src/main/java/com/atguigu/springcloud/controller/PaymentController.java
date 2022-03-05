package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String ServerPort;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springcloud zookeeper"+ServerPort;
    }

}
