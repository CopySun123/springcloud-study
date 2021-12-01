package com.copysun.nacosservice.job;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author CopySun
 * @date 2020/12/24 15:33
 * @Description 任务类
 */
public class Job1 implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello world");
    }
}
