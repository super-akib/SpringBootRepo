package com.demo.service;

import com.demo.entity.Customer;

public interface ICustomerManagementService
{   
	//Business method for customer record fetch by id
	Customer findCustomerById(Integer customerId);
	//Business method for customer record fetch by first name
	Customer findCustomerByFirstName(String firstName);
	//Business method for customer record fetch by last name
	Customer findCustomerByLastName(String lastName);
	//Business method for customer record fetch by email id
	Customer findCustomerByEmailId(String emailId);
	//Business method for customer record fetch by phone number
	Customer findCustomerByPhoneNumber(String phoneNumber);
	//Business method for customer record fetch by first and last name
	Customer findCustomerByFirstAndLastName(String firstName,String lastName);
	//Business method for customer record fetch by first name first character 
	Customer findCustomerByFirstNameStartWith(String prefix);
	//Business method for customer record fetch by last name last character
	Customer findCustomerByLastNameEndsWith(String suffix);
	
	
     
    
} 
