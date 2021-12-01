package com.copysun.nacosservice.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author CopySun
 * @date 2020/12/24 15:35
 * @Description
 */
public class SchedulerUtil {
    public static void handleSimpleTrigger(String jobName, String jobGroupName,
                                           String triggerName, String triggerGroupName, Class jobClass,
                                           int time, int count){
        // 通过stdSchedulerFactory获取一个调度器工厂
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler=null;

        try {
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerFactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroupName).build();
            // 定义调度触发规则
            //使用simpleTrigger规则
            Trigger trigger= TriggerBuilder.newTrigger().withIdentity(triggerName,
                    triggerGroupName)
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(time).withRepeatCount(count))
                    .startNow().build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);
            // 启动调度
            scheduler.start();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
