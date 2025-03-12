package com.nit.commons;

import com.nit.sbean.Product;
import com.nit.sbean.User;

public interface IPayment 
{
	   void	processOrder(User user, Product product);
}
