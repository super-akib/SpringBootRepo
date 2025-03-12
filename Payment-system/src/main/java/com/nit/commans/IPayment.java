package com.nit.commans;

import com.nit.model.User;

public interface IPayment 
{  
    // abstract method
	public void processPayment(User  user, double amount);
}
