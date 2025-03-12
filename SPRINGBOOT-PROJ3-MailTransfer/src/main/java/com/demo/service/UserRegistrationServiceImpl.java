package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.UserData;
import com.demo.repository.IUserRegistrationRepository;
@Service
public class UserRegistrationServiceImpl implements IUserRegistrationService {

	@Autowired
	private IUserRegistrationRepository  userRegistration;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public void userRegistration(UserData userData)
	{
	    int userId=	userRegistration.save(userData).getUserId();
	    
	    if(userId >0)
	    {   
	    	  emailService.sendMail(userData);
	    	  
	    	System.out.println("User sucessfully Registered there id is :"+userId);
	    }
	    else
	    {
	    	System.err.println("User not registered .");
	    }

	}

	@Override
	public UserData fetchUserDataByEamilId(String emailId) 
	{
		return userRegistration.findByEmail(emailId); 
	}

}
