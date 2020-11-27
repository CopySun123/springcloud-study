package com.copysun.openfeign.consumerservice.service;


import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author CopySun
 * @date 2020/11/16 16:25
 */
@Service
public class StreamHandleService {

    @StreamListener(Processor.INPUT)
    public void receive1(String message,@Headers Map<String, String> head){
        System.out.println(head);
        System.out.println("收到日志消息:"+message);
    }

}
