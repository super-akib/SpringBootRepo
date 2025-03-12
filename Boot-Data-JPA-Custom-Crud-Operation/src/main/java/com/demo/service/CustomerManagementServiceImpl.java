package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Customer;
import com.demo.repository.CustomerManagementRepository;
@Service
public class CustomerManagementServiceImpl implements ICustomerManagementService {
 
	//Field level injection has-a property of repository interface
	@Autowired
	private CustomerManagementRepository  customerManagementRepository;
	
    //Business method for fetch customer object by id  
	@Override
	public Customer findCustomerById(Integer customerId)
	{
        //get customer object 	
		return customerManagementRepository.findById(customerId).orElseThrow(()-> new IllegalArgumentException("Invalid customer id try again"));
	}

	//Business method for fetch customer object by first name
	@Override
	public Customer findCustomerByFirstName(String firstName) {
		
		//Convert string into upper-case and pass
		Customer customer = customerManagementRepository.findByFirstName(firstName.toUpperCase());
		
		if(customer != null)
		{			
			return customer;
		}
		else
		{
			throw new IllegalArgumentException(firstName+" name is not found ");
		}
	}

	//Business method for fetch customer object by last name
	@Override
	public Customer findCustomerByLastName(String lastName) {
		//Convert string into upper-case and pass
				Customer customer = customerManagementRepository.findByLastName(lastName.toUpperCase());
				
				if(customer != null)
				{			
					return customer;
				}
				else
				{
					throw new IllegalArgumentException(lastName+" name is not found ");
				}
	}

	//Business method for fetch customer object by email id
	@Override
	public Customer findCustomerByEmailId(String emailId)
	{   
		//get customer object from database table
		 Customer customer = customerManagementRepository.findByEmailId(emailId);
		 if(customer != null)
			{			
				return customer;
			}
			else
			{
				throw new IllegalArgumentException(emailId+" is not found ");
			}
	}

	//Business method for fetch customer object by phone number
	@Override
	public Customer findCustomerByPhoneNumber(String phoneNumber) {
		
		if(phoneNumber.isEmpty())
		{
			throw new IllegalArgumentException("We can not pass empty string object");
		}
		else
		{  
			try {
				 Long.parseLong(phoneNumber);	
				  
			 return	customerManagementRepository.findByPhoneNumber(phoneNumber);
				
			}
			catch(NumberFormatException numberFormatException)
			{
				throw new RuntimeException("We can pass only numeric integral values");
			}
		}
	}

	//Business method for fetch customer object by first name and last
	@Override
	public Customer findCustomerByFirstAndLastName(String firstName, String lastName) {
		
		return null;
	}

	@Override
	public Customer findCustomerByFirstNameStartWith(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByLastNameEndsWith(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

}
