package com.copysun.producer.producerservice.controller;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
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
    private Source source;


    @GetMapping(value = "/sendMsg")
    public void sendMsg(){
        System.out.println("进来了。。。");
        for(int i=1;i<=1000000;i++){
            source.output().send(MessageBuilder.withPayload("测试重试消息第"+i+"条")
                    .build());
        }
//        source.output().send(MessageBuilder.withPayload("发送消息").build());
    }

//    @StreamListener(Processor.INPUT)
    public void receive(String ackMessage){
        System.out.println("回执消息为:"+ackMessage);
    }

}
