package com.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.UserData;
import com.demo.service.IUserDataManagementService;
@Component
public class TestPagingRunner implements CommandLineRunner
{

	@Autowired
	private IUserDataManagementService   userService;
	
	@Override
	public void run(String... args) throws Exception
	{
		  UserData  user = UserData.builder().firstName("Mike").lastName("Dell").emailId("mikedell@gmail.com").countryName("America").build(); 
		  UserData  user1 = UserData.builder().firstName("jake").lastName("anthony").emailId("jake@gmail.com").countryName("America").build(); 
		  UserData  user2 = UserData.builder().firstName("Martin").lastName("Dell").emailId("martindell@gmail.com").countryName("Africa").build(); 
		  UserData  user3 = UserData.builder().firstName("Alius").lastName("mike").emailId("aliusmike@gmail.com").countryName("America").build(); 
		  UserData  user4 = UserData.builder().firstName("tomb").lastName("desuza").emailId("tomb@gmail.com").countryName("Australia").build(); 
		  UserData  user5 = UserData.builder().firstName("virat").lastName("jain").emailId("jain@gmail.com").countryName("India").build(); 
		  UserData  user6 = UserData.builder().firstName("rohit").lastName("mohan").emailId("rohit@gmail.com").countryName("India").build(); 
		  
		 
		 // userService.saveListOfUserData(List.of(user, user1, user2, user3,user4, user5,user6));
		 
 
		
	    
		  userService.getAllUsersData(1, 3);
		
		
	}

}
