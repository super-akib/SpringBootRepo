package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IEmployeeDao;
import com.demo.model.Employee;

@Service("service")
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeDao employeeDao;
    
	private String confirmationMessage ;
	
	@Override
	public String addEmployeeRecord(Employee employee) {
	   	
		
		if (employee != null) {

		    try {
		      confirmationMessage	=	employeeDao.saveEmployeeData(employee);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		} 
		else
		{
			throw new NullPointerException();
		}
		return confirmationMessage;
	}

	@Override
	public List<Employee> retrieveAllEmployeeRecord() {
		
		List<Employee> empList = null;
		try {
			   //fetch all employee data through the retrieveAllEmployee method
			  empList =employeeDao.retrieveAllEmployee();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public Employee findEmployeeRecordById(Integer employeeId) {
		
		Employee emp =null;
		try {
		      emp =	employeeDao.findEmployeeById(employeeId);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String updateEmployeeRecordById(Integer employeeId, Double salary) {
		
		
		try {
			
		   confirmationMessage = employeeDao.updateEmployeeById(salary, employeeId);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return confirmationMessage;
	}

	@Override
	public String deleteEmployeeById(Integer employeeId) {
		
		try {
		  confirmationMessage = employeeDao.deleteEmployeeById(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return confirmationMessage;
	}

	
}
