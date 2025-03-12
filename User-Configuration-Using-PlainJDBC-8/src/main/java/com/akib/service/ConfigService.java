package com.akib.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("application.properties")
public class ConfigService {
	
	@Value("${database.url}")
	private String databaseURL;
	
	@Value("${database.username}")
	private String databaseUserName;
	
	@Value("${database.password}")
	private String databasePassword;

	@Value("${user.name}")
	private String userName;
	
	@Value("${user.email}")
	private String emailId;
	
	@Value("${user.age}")
	private Integer age;
	
	//Database configuration print method
	public void printDatabaseConfig()
	{
		System.out.println("---------------Database-Configurations---------------");
		System.out.println("Database Url:"+databaseURL);
		System.out.println("Database UserName:"+databaseUserName);
		System.out.println("Database password:"+databasePassword);
	}
	
	//User configuration print method
	public void printUserConfig()
	{
		System.out.println("---------------User-Configurations---------------");
		System.out.println("User Name:"+userName);
		System.out.println("User mailId:"+emailId);
		System.out.println("User age:"+age);
	}
	
	//Data store in database using this method persistent logic
	
	public void storeUserConfigInDatabase()
	{
	   	
	   if(age>=18 && age<=64)
	   {   
		try(Connection con = DriverManager.getConnection(databaseURL,databaseUserName,databasePassword))
		{
			try(PreparedStatement preparStatement = con.prepareStatement("INSERT INTO USERS (USER_NAME,EMAIL,AGE) VALUES(?,?,?)"))
			{
				 preparStatement.setString(1, userName);
				 preparStatement.setString(2,emailId);
				 preparStatement.setInt(3, age);
				 
				 preparStatement.executeUpdate();
				 System.out.println("Data added sucessfully in users table");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	   }
	   else
	   {
		 throw new IllegalArgumentException("Please enter valide age 18 to 64 between ") ;  
	   }//
	}
	
}
