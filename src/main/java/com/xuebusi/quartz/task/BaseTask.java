package com.xuebusi.quartz.task;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by SYJ on 2017/10/7.
 */
public class BaseTask implements Job{
    @Autowired
    private Scheduler scheduler;

    @PostConstruct //等同于 init-method
    public void init() {
        //需要定义jobDetail
        JobDetail jobDetail = JobBuilder.newJob(this.getClass()).withIdentity(this.getClass().getSimpleName() + "_job", this.getClass().getSimpleName() + "_group").build();

        //定义trigger
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().withSchedule(simpleScheduleBuilder).build();

        String cronEexpression = getCronEexpression();//由子类提供该表达式
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(this.getClass().getSimpleName() + "_trigger", this.getClass().getSimpleName() + "_group").withSchedule(CronScheduleBuilder.cronSchedule(cronEexpression)).build();


        //启动job
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        //删除job
        /*try {
            scheduler.deleteJob(new JobKey("job1", "group1"))
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //这里并没有真正意义上的实现
    }

    public String getCronEexpression() {
        return null;
    }
}
