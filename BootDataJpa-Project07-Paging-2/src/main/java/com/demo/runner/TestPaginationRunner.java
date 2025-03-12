package com.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Product;
import com.demo.service.IProductManagementService;
@Component
public class TestPaginationRunner implements CommandLineRunner {
    
	@Autowired
	private IProductManagementService productService;
	
    @Override
	public void run(String... args) throws Exception
	{
	      //create product class objects 
    	Product product1 = Product.builder().productName("Amazon Echo").brandName("Amazon").madeIn("USA").price(199.0).build();
    	Product product2 = Product.builder().productName("BPhone 3").brandName("BKAV").madeIn("Vitnam").price(399.0).build();
    	Product product3 = Product.builder().productName("Civic").brandName("Honda").madeIn("Japan").price(29000.0).build();
    	Product product4 = Product.builder().productName("Ecovacs Deboot Robot").brandName("Ecovacs").madeIn("China").price(299.0).build();
    	Product product5 = Product.builder().productName("Galaxy Note 10").brandName("Samsung").madeIn("Vietname").price(899.0).build();
    	Product product6 = Product.builder().productName("Iphone 15 pro max").brandName("Apple").madeIn("USA").price(145000.0).build();
        
    	// make list collection object for products objects	
    	//Invoke save method of service class to Store products objects
    	productService.stroeProductsInfo(List.of(product1,product2,product3,product4,product5,product6));
	}

}
