package com.nit.sbean;

import org.springframework.stereotype.Component;

import com.nit.commans.IPayment;
import com.nit.model.User;
@Component("payPal")
public class PayPalPayment implements IPayment {

	@Override
	public void processPayment(User user, double amount)
	{
	    System.out.println("PayPal payment amount of Rs."+amount+" is processed for the :"+user.getUserName());	 
	}

}
