package com.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.UserData;
import com.demo.service.IUserRegistrationService;
@Component
public class UserRegistrationTest implements CommandLineRunner {
    
	@Autowired
	private  IUserRegistrationService  service;
	@Override
	
	public void run(String... args) throws Exception 
	{
		UserData user1 = UserData.builder().userName("Akib").emailId("makibmrabbani313786@gmail.com").build();
		
		//invoke register method of service class
       service.userRegistration(user1);
		
		//find record by user Email id
		UserData userData = service.fetchUserDataByEamilId("mohdakib7385@gmail.com");
	
		 System.out.println(userData);
	}

}
