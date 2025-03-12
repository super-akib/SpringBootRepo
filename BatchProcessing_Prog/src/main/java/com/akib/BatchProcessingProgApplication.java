package com.akib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.akib.model.Company;
import com.akib.model.Employee;

@SpringBootApplication

public class BatchProcessingProgApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(BatchProcessingProgApplication.class, args);
		Employee emp = run.getBean(Employee.class);
		System.out.println(emp);
		
		Company company = run.getBean(Company.class);
		System.out.println(company);
	}
}
