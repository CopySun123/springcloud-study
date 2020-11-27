package com.copysun.openfeign.consumerservice.controller;

import com.copysun.openfeign.consumerservice.service.ProduceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CopySun
 * @date 2020/11/13 15:22
 */
@RestController
public class ConsumerController {

    @Resource
    private ProduceService produceService;

    @GetMapping("/testSay")
    public void testSay(){
        produceService.producerSay();
        System.out.println("这是消费者!");
    }
}
