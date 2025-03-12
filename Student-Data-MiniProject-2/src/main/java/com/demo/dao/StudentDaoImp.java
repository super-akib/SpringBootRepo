package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository("studentDao")
public class StudentDaoImp implements IStudentDao {

	private final Connection connection;

	// this property for store data
	private final String INSERT_STUDENT_DATA = "INSERT INTO STUDENT_RECORD VALUES (?,?,?,?)";
	// this property for retrieve all student data
	private final String SELECT_ALL_STUDENT_DATA = "SELECT * FROM  STUDENT_RECORD";
	// this property for retrieve student data based on the id
	private final String SELECT_STUDENT_BASED_ON_ID = "SELECT * FROM  STUDENT_RECORD WHERE STUDENT_ID =?";
    
	
	// Constructor
	public StudentDaoImp(DataSource dataSource) throws Exception  
	{
		super();
		this.connection  = dataSource.getConnection();
	}

	
	// this method for storing data into database
	@Override
	public String saveData(Student student) {
		String saveData = "Status:";
		// Try wit resource it will close connection automatically
		try{
			
			PreparedStatement prepareStatement = connection.prepareStatement(INSERT_STUDENT_DATA);
			
			//Assign value to prepareStatement properties
			prepareStatement.setInt(1, student.getStudentId());
			
			prepareStatement.setString(2, student.getStudentName());
			
			prepareStatement.setInt(3, student.getStudentMarks());
			
			prepareStatement.setString(4, student.getStudentGrad());
			
			//Execute the prepared statement
			
			int execute = prepareStatement.executeUpdate();
			
			//check student data is stored or not 
			if(execute>0)
			{
				saveData +="Student data sucessfully saved in student database";
			}
			else
			{
				saveData +="Student data not saved in student database";				
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return saveData;
	}

	// This method used to retrieve all student data from database table
	@Override
	public List<Student> getAll() 
	{
		List<Student> studentList = new ArrayList<>();
		
		try 
		{
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_STUDENT_DATA);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next())
			{   
				// student class object for store database values 
				Student student = new Student();
				
				//get the student data from database and set student class properties using setter method
				student.setStudentId(resultSet.getInt(1));
				student.setStudentName(resultSet.getString(2));
				student.setStudentMarks(resultSet.getInt(3));
				student.setStudentGrad(resultSet.getString(4));
				
				//add student class objects in studentList collection and return
				studentList.add(student);
				
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return studentList;
	}

	// get particular student data based on the student id
	@Override
	public Student FindByid(int id)
	{   
		//Student class object
		Student student = new Student();
        try (PreparedStatement prepareStatement = connection.prepareStatement(SELECT_STUDENT_BASED_ON_ID)) 
        {
        	prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            
            if(resultSet.next() != true)
            {
            	throw new IllegalArgumentException("Your entered student id is invalid please enter valid student Id");
            }
            else
            {
            	//get the student details from table and set the properties of student class properties
            	student.setStudentId(resultSet.getInt(1));
            	student.setStudentName(resultSet.getString(2));
            	student.setStudentMarks(resultSet.getInt(3));
            	student.setStudentGrad(resultSet.getString(4));
            }
        }
        catch(Exception exception)
        {
        	exception.printStackTrace();
        }
		return student;
	}

}
