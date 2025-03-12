package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository("employeeDao")
public class EmployeeDao implements IEmployeeDao {

	// HAS-A property for connection reference
	private Connection connection;
    
	// Database queries for performing given tasks
	private static final String SAVA_EMPLOYEE_RECORD = "INSERT INTO EMPLOYEE_RECORD VALUES (?,?,?,?,?)";
	private static final String RETRIEVE_ALL_EMPLOYEE_DATA = "SELECT *FROM EMPLOYEE_RECORD";
	private static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM EMPLOYEE_RECORD WHERE EMPLOYEE_ID=?";
	private static final String UPDATE_EMPLOYEE_BY_ID = " UPDATE EMPLOYEE_RECORD SET SALARY =? WHERE EMPLOYEE_ID=?";
	private static final String DELETE_EMPLOYEE_RECORD_BY_ID = "DELETE FROM EMPLOYEE_RECORD WHERE EMPLOYEE_ID=?";

	// Test queries executed or not
	private static String testMessage = "";

	// Using Constructor get DataSource object

	public EmployeeDao(DataSource dataSource) throws Exception {
		// get connection object from DataSource
		connection = dataSource.getConnection();
	}

	// it will save the employee details in database
	@Override
	public String saveEmployeeData(Employee employee) throws Exception {
		// it will check data inserted or not
		int check = 0;
		try (PreparedStatement prepareStatement = connection.prepareStatement(SAVA_EMPLOYEE_RECORD)) {
			// Assign the values to prepareStatement properties
			prepareStatement.setInt(1, employee.getEmployeeId());
			prepareStatement.setString(2, employee.getEmployeName());
			prepareStatement.setString(3, employee.getDesignation());
			prepareStatement.setDouble(4, employee.getEmployeeSalary());
			prepareStatement.setString(5, employee.getDepartmentName());

			// Execute query
			check = prepareStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		if (check == 0) {
			throw new IllegalArgumentException("Data can't  store in database . Try again");
		} else {
			testMessage = "Employee data sucessfully stored in Database";
		}
		return testMessage;
	}

	// it will retrieve all employees record from database
	@Override
	public List<Employee> retrieveAllEmployee() throws Exception {
		
		List<Employee> list = new ArrayList<>();
		try (Statement createStatement = connection.createStatement())
		{
			//get resultSet object reference   
			ResultSet resultSet   = createStatement.executeQuery(RETRIEVE_ALL_EMPLOYEE_DATA);
			
			while(resultSet.next())
			{
				//create employee class object
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getInt(1));
				employee.setEmployeName(resultSet.getString(2));
				employee.setDesignation(resultSet.getString(3));
				employee.setEmployeeSalary(resultSet.getDouble(4));
				employee.setDepartmentName(resultSet.getString(5));
				
				//Add employee class objects in list collection
				list.add(employee);
				
			}
			
		}
		return list;
	}

	// find the employee based on the employeeId
	@Override
	public Employee findEmployeeById(Integer employeeId) throws Exception
	{
		Employee  employee = new Employee();
         try (PreparedStatement prepareStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_ID)) {
			
        	 prepareStatement.setInt(1, employeeId);
        	 
        	 ResultSet resultSet = prepareStatement.executeQuery();
        	 
        	 if(resultSet.next())
        	 {
        		 employee.setEmployeeId(resultSet.getInt(1));
        		 employee.setEmployeName(resultSet.getString(2));
        		 employee.setDesignation(resultSet.getString(3));
        		 employee.setEmployeeSalary(resultSet.getDouble(4));
        		 employee.setDepartmentName(resultSet.getString(5));
        	 }
        	 else
        	 {
        		 throw new IllegalArgumentException("Invalide Id:"+employeeId+" .Try again");
        	 }
		}
         catch(Exception exception)
         {
        	 exception.printStackTrace();
         }
		return  employee;
	}

	// Update employee based on the employeeId
	@Override
	public String updateEmployeeById(Double updateSalary, Integer employeeId) throws Exception {

		try (PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID)) {
			prepareStatement.setDouble(1, updateSalary);
			prepareStatement.setInt(2, employeeId);

			// execute query
			int update = prepareStatement.executeUpdate();

			// check employee data updated or not
			if (update == 0) {
				throw new IllegalArgumentException("Invalid " + employeeId + " employee id try again");
			} else {
				testMessage = "Employee salary sucessfully updated there id is:" + employeeId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testMessage;
	}

	// delete employee record based on the employeeId
	@Override
	public String deleteEmployeeById(Integer employeeId) throws Exception {

		try (PreparedStatement prepareStatement = connection.prepareStatement(DELETE_EMPLOYEE_RECORD_BY_ID))
		{      
			    prepareStatement.setInt(1, employeeId);
               int delete = prepareStatement.executeUpdate();  
               if(delete ==0)
               {
            	   throw new IllegalArgumentException("Invalid  id:"+employeeId+" .Please try again");
               }
               else
               {
            	   testMessage="Employee record  sucessfully deleted  from database";
               }
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return testMessage;
	}

}
