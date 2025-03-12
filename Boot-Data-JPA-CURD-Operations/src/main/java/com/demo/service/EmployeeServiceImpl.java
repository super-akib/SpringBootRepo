package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repository.IEmployeeRepository;
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {
  @Autowired	
  private IEmployeeRepository  employeeRepository;
   	
  
   //save employee data in database table
	@Override
	public void saveEmployeeData(Employee employee)
	{
		if(employee != null)
		{
		    //invoke save method of repository class
	    	 employeeRepository.save(employee);
	    	System.out.println("Employee"+employee.getEmployeeId()+" data sucessfully inserted");
		}
		else
		{
			throw new NullPointerException("Employee details object is null");
		}
	}

	@Override
	public List<Employee> getAllEmployee()
	{  
		 List<Employee> list  = (List<Employee>) employeeRepository.findAll();
		 
		 if(list.isEmpty())
		 {
			 throw new IllegalArgumentException("No records there in database");
		 }
		 else
		 {
			 return list;			 
		 }
	}

	@Override
	public Employee findById(Integer employeeId)
	{
		return employeeRepository.findById(employeeId).orElseThrow(() ->  new IllegalArgumentException("Invalid Employee id try again"));
	}

	@Override
	public void updateEmployeeById(Employee employee) 
	{
		if(employee != null)
		{
			if(employeeRepository.existsById(employee.getEmployeeId()))
			{
				employeeRepository.save(employee);
				System.out.println("Existing employee record updated into new employee record.");
			}
			else
			{
				throw new IllegalArgumentException(employee.getEmployeeId()+" is invalid employee id try again.");
			}
		}
		else
		{
			throw new NullPointerException("Employee object can not be null");
		}

	}

	@Override
	public void deleteEmployeeById(Integer employeeId) 
	{
	    if(employeeRepository.existsById(employeeId))  
		{ 
	    	employeeRepository.deleteById(employeeId);       
	    }
	    else
	    {
	    	throw new IllegalArgumentException(employeeId+" is invalid employee id try again.");
	    }
    
	}

}
