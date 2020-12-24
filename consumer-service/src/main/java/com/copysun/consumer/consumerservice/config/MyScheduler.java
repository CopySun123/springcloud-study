package com.copysun.consumer.consumerservice.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author CopySun
 * @date 2020/12/24 15:01
 * @Description 调度器
 */
@Component
@EnableScheduling
public class MyScheduler {

    @Resource
    private MyTask myTask;


    @Scheduled(fixedDelay = 3000)
    public void run(){
        System.out.println("提示信息:当前任务每隔三秒执行一次");
        myTask.testTask();
    }
}
