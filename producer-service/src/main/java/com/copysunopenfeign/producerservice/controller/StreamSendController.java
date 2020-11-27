package com.copysunopenfeign.producerservice.controller;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CopySun
 * @date 2020/11/13 18:11
 */
@RestController
public class StreamSendController {

    @Resource
    private Processor processor;


    @GetMapping(value = "/sendMsg")
    public void sendMsg(){
        System.out.println("进来了。。。");
        processor.output().send(MessageBuilder.withPayload("日志消息:12345").build());
//        int i=1/0;
    }

    @StreamListener(Processor.INPUT)
    public void receive(String ackMessage){
        System.out.println("回执消息为:"+ackMessage);
    }

}
