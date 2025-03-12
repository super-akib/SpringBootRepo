package com.demo.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.service.IEmployeeDepartmentService;
@Component
public class TestOneToManyRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeDepartmentService  service;
	
	@Override
	public void run(String... args) throws Exception 
	{
		//take list of technologies employee knows 
		//Set<String> listOfTechnologies = 

	}

}
