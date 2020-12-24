package com.copysun.consumer.consumerservice.config;

/**
 * @author CopySun
 * @date 2020/12/24 15:51
 * @Description
 */
public class JobTest {
    public static void main(String[] args) {
        SchedulerUtil.handleSimpleTrigger("44033","3333","44033","3333",MyJob.class,1,8);
    }
}
