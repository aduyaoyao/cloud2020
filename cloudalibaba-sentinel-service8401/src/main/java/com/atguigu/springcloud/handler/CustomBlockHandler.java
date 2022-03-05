package com.atguigu.springcloud.handler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"用户自定义1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"用户自定义2");
    }
}
