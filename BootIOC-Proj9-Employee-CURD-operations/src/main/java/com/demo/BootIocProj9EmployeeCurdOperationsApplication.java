package com.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@SpringBootApplication
public class BootIocProj9EmployeeCurdOperationsApplication {

	public static void main(String[] args) {
		// get IOC Container
		ApplicationContext applicationContext = SpringApplication
				.run(BootIocProj9EmployeeCurdOperationsApplication.class, args);

		// get service class object reference
		EmployeeService employeeService = applicationContext.getBean("service", EmployeeService.class);

// assign the properties values using builder
		Employee emp = Employee.builder().employeeId(101113).employeName("Jully").designation("Developer").employeeSalary(70000.0)
				.departmentName("Backend-Development").build();
	     
		String record = employeeService.addEmployeeRecord(emp);
		
		System.out.println(record);
		//retrieve all employee record 
		List<Employee> list = employeeService.retrieveAllEmployeeRecord();
		for (Employee employee : list) 
		{
			System.out.println(employee);
		}
	    
		
		//get employee record by id
		Employee emp1 = employeeService.findEmployeeRecordById(112233);
		System.out.println(emp1);
		
		//update employee salary by id and invoke service method
		String update  = employeeService.updateEmployeeRecordById(100013, 65000.0);
		
		System.out.println(update);
        
		//invoke service method for delete employee record
		String delete = employeeService.deleteEmployeeById(112233);
		System.out.println(delete);
		
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
