package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetailsFactoryNotFoundException;
import org.springframework.stereotype.Repository;

import com.demo.exceptions.DoctorNotFoundException;
import com.demo.model.Doctor;

@Repository("doctorDao")
public class DoctorDao implements IDoctorDao
{   
	//HAS-A relation property of Connection
    private Connection connection;
	
   
    /*
     * Properties for database queries perform 
     * this are final properties to do the CURD operations on database doctors_record table
     * */
    private static final String SAVE_DOCTOR_DATA =" INSERT INTO DOCTORS_RECOD VALUES(?,?,?,?,?)";
    private static final String RETRIEVE_ALL_DOCTORS_RECODS = "SELECT *FROM DOCTORS_RECOD";
    private static final String RETRIEVE_DOCTOR_RECORD_BY_ID = "SELECT *FROM DOCTORS_RECOD WHERE DOCTOR_ID=?";
    private static final String UPDATE_DOCTOR_RECORD_BY_ID = "UPDATE DOCTORS_RECOD SET SALARY =? WHERE DOCTOR_ID=?";
    private static final String DELETE_DOCTOR_RECORD_BY_ID = "DELETE FROM DOCTORS_RECOD WHERE DOCTOR_ID=?";
    
    
    //get DataSource object and assign to connection object using DoctorDao class constructor
    public DoctorDao(DataSource dataSource) throws SQLException
    {
    	this.connection = dataSource.getConnection();
    }
    
    
	//Method for save doctor records in database table
	@Override
	public void saveDoctorData(Doctor doctor) throws Exception
	{
	    try (PreparedStatement prepareStatement = connection.prepareStatement(SAVE_DOCTOR_DATA)) 
	    {
	    	 //Assign all doctor class properties values to PreparedStatemnet setter methods 
			  prepareStatement.setInt(1, doctor.getDoctorId());
			  prepareStatement.setString(2, doctor.getDoctorName());
			  prepareStatement.setString(3, doctor.getSpecialization());
			  prepareStatement.setDouble(4, doctor.getSalary());
			  prepareStatement.setString(5, doctor.getDepartment());
			  
			  //execute the query
			  int i = prepareStatement.executeUpdate();
			 
			  //check data will be store or not
			  
			  if(i<=0)
			  {
				  throw new IllegalArgumentException("Data cann't stored in data base");
			  }
			  
			  System.out.println("Data sucessfully stored in database ");
				  
		}
	    catch(SQLException sqlException)
	    {
	    	System.err.println(sqlException);
	    }
	    catch(Exception exception)
	    {
	    	throw exception;
	    }
	}
     
	//Method for retrieve all doctors records from database table
	@Override
	public List<Doctor> retrieveAllDoctorsData() throws Exception 
	{
		List<Doctor> list = new ArrayList<>();
		try(Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(RETRIEVE_ALL_DOCTORS_RECODS))
		{
			
			while(resultSet.next())
			{
				Doctor doctor = Doctor.builder().doctorId(resultSet.getInt(1)).doctorName(resultSet.getString(2)).specialization(resultSet.getString(3)).salary(resultSet.getDouble(4)).department(resultSet.getString(5)).build();
			  
			     list.add(doctor);
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	//Method for retrieve doctor record based on there Id from  database table
	@Override
	public Doctor findDoctorDataById(Integer doctorId) throws Exception
	{
		Doctor doctor = null;
		try (PreparedStatement prepareStatement = connection.prepareStatement(RETRIEVE_DOCTOR_RECORD_BY_ID))
		{
		  	 prepareStatement.setInt(1, doctorId);
		  	 try (ResultSet resultSet = prepareStatement.executeQuery()) {
				
			   if(resultSet.next())
			   {
				   doctor = Doctor.builder().doctorId(resultSet.getInt(1)).doctorName(resultSet.getString(2)).specialization(resultSet.getString(3)).salary(resultSet.getDouble(4)).department(resultSet.getString(5)).build();
			   }
			   else
			   {
				   throw new DoctorNotFoundException(doctorId);
			   }
		  	 
		  	 };
			   
		}
		catch(SQLException sqlException)
		{
			System.err.println(sqlException);
		}
		return doctor;
	}
     
	//Method for update doctor record based on there  database table
	@Override
	public void updateDoctorData(Integer doctorId, Double updateSalary) throws Exception {
		try (PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_DOCTOR_RECORD_BY_ID))
		{
			 prepareStatement.setDouble(1, updateSalary);
			 prepareStatement.setInt(2, doctorId);
			 
		  int k	= prepareStatement.executeUpdate();
		  
		  if(k<0)
		  {
			  throw new DoctorNotFoundException(doctorId);
		  }
		  System.out.println("Doctor salary update sucessfully");
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
	}

	@Override
	public void deleteDoctorDataById(Integer doctorId) throws Exception 
	{
		try (PreparedStatement prepareStatement = connection.prepareStatement(DELETE_DOCTOR_RECORD_BY_ID)) {
			  
			prepareStatement.setInt(1, doctorId);
			int i = prepareStatement.executeUpdate();
			
			if(i<=0)
			{
				throw new DoctorNotFoundException(doctorId);
			}
			System.out.println("Doctor record is deleted sucessfully");
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		
	}

}
