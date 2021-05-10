package com.jin.springboot.config;

import com.jin.springboot.job.FirstJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(FirstJob.class).storeDurably().build();
    }


    @Bean
    public Trigger trigger1() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                // 每5秒执行一次
                .withIntervalInSeconds(5)
                // 永久重复执行
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .withIdentity("trgger1","group1")
                .withSchedule(scheduleBuilder)
                .forJob(jobDetail())
                .build();
    }


    @Bean
    public Trigger trigger2() {
        return TriggerBuilder.newTrigger()
                .withIdentity("trgger2","group1")
                // 每5秒执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ? *"))
                .forJob(jobDetail())
                .build();
    }




}
