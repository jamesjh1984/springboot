package com.jin.springboot.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstJob implements Job {

    private Logger logger = LoggerFactory.getLogger(FirstJob.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();

        logger.info("Trigger: " + triggerKey.getName() +
                    ", Group: " + triggerKey.getGroup() +
                    " --> " + simpleDateFormat.format(new Date()) + "...");
    }
}
