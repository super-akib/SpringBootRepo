package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;
@Service("service")
public class EmployeService implements IEmployeeService {
    
	// Field level injection HAS-A relation 
	@Autowired 
	private EmployeeDao employeeDao;
	
	
	
	@Override
	public List<Employee> fetchAllEmployeeByDesignation(String designation1, String designation2, String designation3)
			throws Exception 
	{
		//it will return employee list collection based on the designation
		return  employeeDao.viewEmployeeDeatails(designation1, designation2, designation3);	
	}

}
