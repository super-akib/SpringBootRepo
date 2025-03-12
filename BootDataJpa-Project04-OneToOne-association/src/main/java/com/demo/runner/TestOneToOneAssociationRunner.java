package com.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Address;
import com.demo.entity.User;
import com.demo.service.IUserManagementService;
@Component
public class TestOneToOneAssociationRunner implements CommandLineRunner {

	@Autowired
	private IUserManagementService service;
	@Override
	public void run(String... args) throws Exception 
	{
          //create Address class object
		Address address1 =  Address.builder().streetName("Ameerpet").cityName("Hyderabad").stateName("Telangana").countryName("India").build(); 
	     //create user object and pass address object as a property on user class
		User  user1 = User.builder().userName("Mohd Akib").address(address1).build();
		
		//invoke service class save method
	   // String data = service.saveUserData(user1);
	    //print message user saved or not
	    //System.out.println(data);
		//fetch user data by id
////		User user = service.getUserById(3);
////		Address address = user.getAddress();
////		System.out.println(user+" "+address);
//		
//		//fetch multiple record
//		List<User> allUserData = service.getAllUserData();
//		
//		for (User user : allUserData) 
//		{
//			System.out.println(user +" "+user.getAddress());
//		}
		
		String id = service.deleteUserDataById(3);
		System.out.print(id);
	}

}
