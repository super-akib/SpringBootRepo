package com.nit.runner;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BatchJobRunner implements CommandLineRunner {

	@Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private org.springframework.batch.core.Job job;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting the Batch Job...");

        JobExecution execution = jobLauncher.run(job, new JobParameters());

        System.out.println("Job Exit Status: " + execution.getStatus());
        System.out.println("Batch job completed.");
    }
}
