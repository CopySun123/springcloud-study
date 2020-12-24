package com.copysun.consumer.consumerservice.config;

import org.springframework.stereotype.Component;

/**
 * @author CopySun
 * @date 2020/12/24 14:59
 * @Description
 */
@Component
public class MyTask {

    private int count=0;
    public void testTask(){
        count++;
        System.out.println("这已经是第"+count+"次了，你行不行啊？");
    }
}
