package com.nit.cfg;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.nit.listner.JobMonitoringListener;
import com.nit.model.Employee;
import com.nit.processor.EmployeeItemProcessor;
import com.nit.repo.IEmployeeRepo;

@Configuration
public class BatchConfig {

    private final JobMonitoringListener listener;
    private final EmployeeItemProcessor processor;
    private final IEmployeeRepo empRepo;

    public BatchConfig(JobMonitoringListener listener, EmployeeItemProcessor processor, IEmployeeRepo empRepo) {
        this.listener = listener;
        this.processor = processor;
        this.empRepo = empRepo;
        System.out.println("BatchConfig.BatchConfig()");
    }

    @Bean
    public FlatFileItemReader<Employee> createReader() {
        return new FlatFileItemReaderBuilder<Employee>()
                .name("myItemReader")
                .resource(new ClassPathResource("Employee_Info.csv"))
                .delimited()
                .delimiter(",")
                .names("id", "name", "address", "salary")
                .targetType(Employee.class)
                .build();
    }

    @Bean
    public RepositoryItemWriter<Employee> createWriter() {
        return new RepositoryItemWriterBuilder<Employee>()
                .repository(empRepo)
                .methodName("save")
                .build();
    }

    @Bean(name = "step1")
    public Step createStep1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
            .<Employee, Employee>chunk(3, transactionManager)  // Define chunk size (3 rows per transaction)
            .reader(createReader())   // Use the CSV reader
            .processor(processor)     // Use the processor to process Employee data
            .writer(createWriter())   // Use the writer to write processed Employee data into the database
            .build();
    }

    @Bean(name = "job1")
    public Job createJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("job1", jobRepository)
            .incrementer(new RunIdIncrementer())  // Increment job run IDs
            .listener(listener)  // Listener to track job execution details
            .start(step1)        // Start with step1
            .build();
    }

}
