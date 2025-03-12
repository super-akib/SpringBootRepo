package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.sbean.Product;
import com.nit.sbean.User;
import com.nit.service.OrderProcessingService;

@SpringBootApplication
public class OrderPlacingSystem02Application {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(OrderPlacingSystem02Application.class, args);
		
		User user = User.builder().userId(101).userName("Akib").emailId("mohdakib@gmail.com").address("Ameerpet Hydrabad").build();
		// get product object 
		Product product = Product.builder().productId(1).productName("sdf").productPrice(15200.2).build();
		
		//get Service class object from IOC
		
		OrderProcessingService service = applicationContext.getBean(OrderProcessingService.class);
		
		
		//invoke business method of service class
		service.processUserOrder(user, product, "creditCard");
	}

}
