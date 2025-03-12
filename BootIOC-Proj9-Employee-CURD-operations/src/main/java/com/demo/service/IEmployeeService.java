package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface IEmployeeService {

//abstract methods for CURD services
	
	 public String addEmployeeRecord(Employee employee);
 	 public List<Employee> retrieveAllEmployeeRecord();
 	 public Employee findEmployeeRecordById(Integer employeeId);
 	 public String updateEmployeeRecordById(Integer employeeId,Double salary);
 	 public String deleteEmployeeById(Integer employeeId);

} 


