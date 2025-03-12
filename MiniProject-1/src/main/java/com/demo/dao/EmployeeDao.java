package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository("empDao")
public class EmployeeDao  implements IEmployeeDao
{   
	//SQL query for retrieve data from 
	private static final String GET_EMPLOYEE_BY_DESIGNATION = "SELECT * FROM EMPLOYEE WHERE JOB  IN(?,?,?) ORDER BY JOB";
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Employee> viewEmployeeDeatails(String designation1, String designation2, String designation3)
			throws Exception 
	{
		// List collection for employee data retrieve from database
		List<Employee>  list = new ArrayList<>();
		
		//get connection object from DataSource class
		try(Connection connection = dataSource.getConnection())
		{ 
			//invoke the prapareStatement
			   PreparedStatement prepareStatement = connection.prepareStatement(GET_EMPLOYEE_BY_DESIGNATION);
			   
			   //Inject the values in prepareStatements
			   prepareStatement.setString(1, designation1);
			   prepareStatement.setString(2, designation2);
			   prepareStatement.setString(3, designation3);
			   
			   //Execute the query
			     try(ResultSet resultSet = prepareStatement.executeQuery())
			     {
			    	   while(resultSet.next())
			    	   {   
			    		   // Employee object for 
			    		   Employee  employee = new Employee();
			    		   
			    		   employee.setEmployeeNo(resultSet.getInt(1));
			    		   employee.setEmployeeName(resultSet.getString(2));
			    		   employee.setEmployeeJob(resultSet.getString(3));
			    		   employee.setSalary(resultSet.getDouble(4));
			    		   employee.setDepartmentNo(resultSet.getInt(5));
			    		   
			    		   //add employee objects in list collection
			    		   list.add(employee);
			    	   }
			     }
			     catch(SQLException sqlException)
			     {
			    	 sqlException.printStackTrace();
			    	 throw sqlException;
			     }
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw exception;
		}
		
		
		return list;
	}
   
}
