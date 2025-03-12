package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginController
{
	@GetMapping("/login")
	public String getLoginForm()
	{
		return"login_form";
	}
	
   @PostMapping("/login")	
   public String loginForm(@RequestParam("username") String username,@RequestParam("password") String password)
   {  
	   
	   return "show_user_data";
   }
} 
