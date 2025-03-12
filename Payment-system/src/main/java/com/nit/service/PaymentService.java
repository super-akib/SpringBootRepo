package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nit.commans.IPayment;
import com.nit.database.UserDao;
import com.nit.model.User;

@Service
public class PaymentService
{  
	// Field level Injection and HAS_A properties
	@Autowired
	@Qualifier("creditCard")
    private IPayment  creditCardMode;
	
	@Autowired
	@Qualifier("payPal")
	private IPayment  payPalMode;
    @Autowired 
    private UserDao userDao;
    
	//Business method 
	public void processUserPayment(User user, double amount, String type)
	{
		 if(type.equalsIgnoreCase("creditCard"))
		 {
			 creditCardMode.processPayment(user, amount);
		       //store user details in database 
               int i = userDao.insertDataInCreditCard(user);
               if(i>0)
               {
            	   System.out.println("User Details inserted  sucessfully in database");
               }
               else
               {
            	   System.err.println("No data will be inserted please try again");
               }
               
		 }
		 else if(type.equalsIgnoreCase("paypal"))
		 {
			 payPalMode.processPayment(user, amount);
			 
			//store user details in database 
             int i = userDao.insertDataInPaypal(user);
             if(i>0)
             {
          	   System.out.println("User Details inserted  sucessfully in database");
             }
             else
             {
          	   System.err.println("No data will be inserted please try again");
             }
		 }
		 else
		 {
			 throw new  IllegalArgumentException("!Invalide payment mode. try again");
		 }
	}

}

