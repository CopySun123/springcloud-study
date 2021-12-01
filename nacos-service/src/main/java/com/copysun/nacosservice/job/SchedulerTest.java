package com.copysun.nacosservice.job;

/**
 * @author CopySun
 * @date 2020/12/24 15:51
 * @Description
 */
public class SchedulerTest {
    public static void main(String[] args) {
        SchedulerUtil.handleSimpleTrigger("44033","3333","44033","3333", Job1.class,1,8);
    }
}
