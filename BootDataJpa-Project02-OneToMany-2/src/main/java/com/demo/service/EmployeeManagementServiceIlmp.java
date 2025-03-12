package com.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Department;
import com.demo.entity.Employee;
import com.demo.repository.IDeparmentManagementRepository;
import com.demo.repository.IEmployeeManagementRepository;
@Service
public class EmployeeManagementServiceIlmp implements IEmployeeDepartmentService {

	@Autowired
	private IEmployeeManagementRepository empRepository;
	@Autowired
	private IDeparmentManagementRepository deparmentRepository;

	@Override
	public String saveEmployeeRecord(Employee employee) 
	{ 
        if(employee == null)
        {
        	throw new NullPointerException("In this scenario Employee object can not be null.");
        }
        else
        {
        	  //save employee data in employee table
        	   Employee savedEmployee = empRepository.save(employee);
        	   
        	  //get department list from employee object
        	   Set<Department> listOfDepartment = employee.getListOfDepartment();
        	   //set savedEmployee object property to department list
        	   for (Department department : listOfDepartment) 
        	   {
				   department.setEmployee(savedEmployee);
			   }
        	   // save department details in department table
        	   deparmentRepository.saveAll(listOfDepartment);
        	   return savedEmployee.getEmployeeId()+"  employee sucessfully registered.";
        }
      		
	}

}
