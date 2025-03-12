package com.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
@RestController
@RequestMapping("/app1-api")
public class UserRestController
{
   @GetMapping("/show")	
   public ResponseEntity<User> showData()
   {    
	   User user = new User(101,"Mohd Akib", "Mohd Rabbani",7385932895L ,"mohdakib7385@gmail.com", "Salim Khan's Homes Begumpet Hyderabad Telangana-5000018");
	   return new ResponseEntity<>(user,HttpStatus.CREATED);
   }
}
