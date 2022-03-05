package com.atguigu.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProvider implements IMessageProvider{
    @Resource
    private MessageChannel output; //消息发送管道


    @Override
    public String send() {
       String msg = UUID.randomUUID().toString();
       output.send(MessageBuilder.withPayload(msg).build());
       System.out.println(msg);
       return null;
    }
}
