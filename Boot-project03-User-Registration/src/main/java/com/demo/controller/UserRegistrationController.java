package com.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.UserRegistration;
import com.demo.service.IUserRegistrationService;

@Controller
public class UserRegistrationController
{
    
	//Service interface HAS-A property
	private IUserRegistrationService  userService;
	

	public UserRegistrationController(IUserRegistrationService  userService)
	{
		this.userService = userService;
	}
	
	
	@GetMapping("/home")
	public String showHomePage()
	{
		return "index";
	}
	
	@GetMapping("/reg")
	public String getRegister()
	{
		return "register";
	}
	@PostMapping("/register")
	public String userRegister(@ModelAttribute  UserRegistration user,Map<String,Object> map)
	{   
		//invoke service method 
		String registrationMessage = userService.userRegistration(user);
		//set map property
		map.put("message", registrationMessage);
		
		return "index";
	}
}
