package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Customer;

public interface CustomerManagementRepository extends CrudRepository<Customer, Integer>
{    
	 //Find customer record based on first name
     Customer  findByFirstName(String firstName);
     //Find customer record based on last name
     Customer  findByLastName(String lastName);
     //Find customer record based on email address
     Customer findByEmailId(String emailId);
     // Find customer record based on first name and last name
     Customer findByFirstNameAndLastName(String firstName, String lastName);
     //Find customer record based on phone number 
     Customer findByPhoneNumber(String phoneNumber);
     //Find customer record based on first name prefix
     Customer  findByFirstNameStartingWith(String prefix);
     //Find customer record based on last name prefix
     Customer findByLastNameEndingWith(String suffix); 
}
