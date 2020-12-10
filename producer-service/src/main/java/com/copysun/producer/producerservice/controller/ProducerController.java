package com.copysun.producer.producerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CopySun
 * @date 2020/11/13 15:19
 */
@RestController
public class ProducerController {

    @GetMapping(value = "/say")
    @ResponseBody
    public void say(){
        System.out.println("被调用了，哈哈!");
    }
}
