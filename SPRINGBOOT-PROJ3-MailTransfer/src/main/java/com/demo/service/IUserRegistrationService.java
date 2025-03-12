package com.demo.service;

import com.demo.entity.UserData;

public interface IUserRegistrationService 
{
    //Register user 
	void userRegistration(UserData userData);	
	
	//fetch user data by there email id
	UserData fetchUserDataByEamilId(String emailId);
}
