package com.nit.listner;

import java.util.Date;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {

    private long startTime, endTime;

    public JobMonitoringListener() {
        System.out.println("JobMonitoringListener.JobMonitoringListener()");
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("JobMonitoringListener.beforeJob()");
        System.out.println("Job started at: " + new Date());
        System.out.println("Job execution status: " + jobExecution.getStatus());
        startTime = System.currentTimeMillis();
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("JobMonitoringListener.afterJob()");
        System.out.println("Job execution status: " + jobExecution.getExitStatus());
        endTime = System.currentTimeMillis();
        System.out.println("Job execution time: " + (endTime - startTime) + " ms");
    }
}
