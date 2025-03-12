package com.akib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.akib.model.Employee;

@SpringBootApplication
public class EmployeDataUsingPropertiesConfiguration2Application {

	public static void main(String[] args) 
	{
		ApplicationContext applicationContext = SpringApplication.run(EmployeDataUsingPropertiesConfiguration2Application.class, args);
	    
		Employee employee = applicationContext.getBean("employee",Employee.class);
		
		System.out.println(employee);
	}

}
