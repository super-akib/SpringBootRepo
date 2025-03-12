package com.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.controller.PayrollOperationsController;
import com.demo.model.Employee;

@SpringBootApplication
public class MiniProject1Application {

	public static void main(String[] args) 
	{
		//get IOC container
	   ApplicationContext applicationContext =	SpringApplication.run(MiniProject1Application.class, args);
		//get the PayrollOperationController class object
		PayrollOperationsController payrollOperationsController = applicationContext.getBean("payroll",PayrollOperationsController.class);
		
		//invoke payroll class method
		try {
			
			List<Employee> list = payrollOperationsController.showAllEmployeesByDesignation("Developer", "Hr", "Manager");
		
			for (Employee employee : list) {
				
				System.out.println(employee);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
