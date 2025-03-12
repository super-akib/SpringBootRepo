package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import sbean.Employee;

public class TestEmployee {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
        
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Employee employee = context.getBean("emp",Employee.class);
		employee.setEmployeeId(101);
		employee.setEmployeeName("Mohd Akib");
		employee.setEmployeeSalary(75000.0);
		
		System.out.println(employee);
	}
}
