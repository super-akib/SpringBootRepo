package com.nit.sbean;

import org.springframework.stereotype.Component;

import com.nit.commons.IPayment;
@Component("cashOnDelivery")
public class CashOnDeliveryPayment implements IPayment {

	@Override
	public void processOrder(User user, Product product) {
		System.out.println("User -Details:");	
		   System.out.println("-------------");
	       System.out.println("User Id:"+user.getUserId());
	       System.out.println("User Name:"+user.getUserName());
	       System.out.println("User Email:"+user.getEmailId());
	       System.out.println("User Address:"+user.getAddress());
	       
	       System.out.println("Oder -Details:");
	       System.out.println("-------------");
	       System.out.println("Product Id:"+product.getProductId());
	       System.out.println("Product Name:"+product.getProductName());
	       System.out.println("Product Price:"+product.getProductPrice());
	       
	       System.out.println("User pay via Cash on Delivery the amount is  Rs."+product.getProductPrice());
	}

}
