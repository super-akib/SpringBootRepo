package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nit.commons.IPayment;
import com.nit.database.Dao;
import com.nit.sbean.Product;
import com.nit.sbean.User;

@Service
public class OrderProcessingService 
{   
	@Autowired
	@Qualifier("creditCard")
    private IPayment    creditCardMode;
	
	@Autowired
	@Qualifier("cashOnDelivery")
	private IPayment cashOnDelivery;
    
	@Autowired
	private Dao  dao;
	
	public void processUserOrder(User user, Product product, String paymentType)
	{
		int k=0;
		if(paymentType.equalsIgnoreCase("creditCard"))
		{
			creditCardMode.processOrder(user, product);
			k=dao.insertDataInCreditCardTable(user, product);
			if(k>0)
				System.out.println("stored in db");
			else
				System.err.println("Not stored");
		}
		else if(paymentType.equalsIgnoreCase("cash"))
		{
			cashOnDelivery.processOrder(user, product);
			k=dao.insertDataInCodTable(user, product);
			if(k>0)
				System.out.println("stored in db");
			else
				System.err.println("Not stored");
		}
		else
		{
			throw new IllegalArgumentException("!Invalid payment type . Please try again");
		}
			
	}
}
