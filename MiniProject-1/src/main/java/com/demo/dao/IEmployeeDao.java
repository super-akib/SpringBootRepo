package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface IEmployeeDao 
{    
	//Abstract method for employee data 
    public List<Employee> viewEmployeeDeatails(String designation1,String designation2,String designation3) throws Exception; 
}
