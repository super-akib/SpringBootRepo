package com.demo.microservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp-api")
public class EmployeeMsController
{
	@GetMapping("/show")
     public ResponseEntity<String> showDetails()
     {
    	return new ResponseEntity<String>("Eureka Discovery Client",HttpStatus.OK); 
     }
}
