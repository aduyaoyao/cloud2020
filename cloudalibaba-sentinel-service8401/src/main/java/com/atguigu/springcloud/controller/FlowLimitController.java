package com.atguigu.springcloud.controller;



import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName());
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }


    @GetMapping("/testD")
    public String testD()
    {
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        int a = 10/0;
        log.info("testD 测试异常比例");
        return "------testD";
    }
    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String hotKey(@RequestParam(value = "p1",required = false)String p1,
                         @RequestParam(value = "p2",required = false)String p2){
        return "------testE HotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

}
 
 
