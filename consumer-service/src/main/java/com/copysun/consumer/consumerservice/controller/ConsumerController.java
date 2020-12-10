package com.copysun.consumer.consumerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CopySun
 * @date 2020/11/13 15:22
 */
@RestController
public class ConsumerController {


    @GetMapping("/testSay")
    public void testSay(){
        System.out.println("这是消费者!");
    }
}
