package com.demo.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.dto.UserDto;
import com.demo.service.IUserManagementService;
@Component
public class TestUserRegistrationRunner implements CommandLineRunner {
     
	@Autowired
	private IUserManagementService  userService;    
	@Override
	public void run(String... args) throws Exception
	{
		 //Take run time values using scanner class object reference
	     Scanner scan = new Scanner(System.in);
	     
	     
	     System.out.print("Enter user-name:"); 
	     String userName = scan.next();
	     System.out.print("Enter first name:"); 
	     String firstName = scan.next();
	     System.out.print("Enter last name:"); 
	     String lastName = scan.next();
	     System.out.print("Enter Email id:"); 
	     String emailId = scan.next();
	     System.out.print("Confirm Email id:"); 
	     String confirmEmailId = scan.next();
	     System.out.print("Enter new password :"); 
	     String password = scan.next();
	     System.out.print("Confirm password:"); 
	     String confirmPassword = scan.next();
	     System.out.print("Enter phone number:");
	     String phoneNumber = scan.next();
	     
	     
	     //create userDto object 
	       UserDto userDto  = UserDto.builder().userName(userName).firstName(firstName).lastName(lastName).emailId(emailId).confirmEmailId(confirmEmailId).userPassword(password).confirmUserPassword(confirmPassword).phoneNumber(phoneNumber).build();   
	     
	       
	     // invoke service method 
	     String registration = userService.userRegistration(userDto);
	     System.out.println(registration);
       
	     scan.close();
	}

}
