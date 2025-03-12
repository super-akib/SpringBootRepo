package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface IEmployeeService 
{
	//it will invoke  save() method to save data in database
    void saveEmployeeData(Employee employee);
    //Fetch all the employees data 
    List<Employee>  getAllEmployee();
    //fetch employee by id 
    Employee findById(Integer employeeId);
    //update employee data 
    void updateEmployeeById(Employee employee);
    //delete employee by id 
    void deleteEmployeeById(Integer employeeId);
    
        
}
