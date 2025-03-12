package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface IEmployeeDao
{
      //abstract methods 
	//method for save employee data in database
	public String saveEmployeeData(Employee employee) throws Exception;
	
	//method for retrieve  all data from database table
	public List<Employee>  retrieveAllEmployee() throws Exception;
	
	//method for find particular field data based on the id
	public Employee findEmployeeById(Integer employeeId) throws Exception;
	
	//method for  update particular field based on the id
	public String  updateEmployeeById(Double updateSalary,Integer employeeId) throws Exception;
	
	//method for delete particular field based on the id
	public String deleteEmployeeById(Integer employeeId) throws Exception;
}
