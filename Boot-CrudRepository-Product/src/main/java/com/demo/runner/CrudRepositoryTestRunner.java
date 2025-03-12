package com.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.service.IProductManagementService;
@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {
 
	@Autowired
	private IProductManagementService   service;
	
	@Override
	public void run(String... args) throws Exception {
	    
		/*
		 * //Create product object Product product1 =
		 * Product.builder().productName("Acer Aspire5").modelNumber("AC56-37-65").
		 * productPrice(65000.0).productQuntity(2).manufacturerName("Acer").build(); //
		 * invoke save method of service class service.saveProduct(product1);
		 * 
		 * Product product1 =
		 * Product.builder().productName("Samsung Galexy S24 Ultra ").modelNumber(
		 * "SMT-24-02").productPrice(125000.0).productQuntity(2).manufacturerName(
		 * "Samsung").build(); Product product2 =
		 * Product.builder().productName("Iphone 15 pro Max").modelNumber("SN0752").
		 * productPrice(165000.0).productQuntity(2).manufacturerName("Apple").build();
		 * Product product3 =
		 * Product.builder().productName("Asus Tuf F15").modelNumber("ASS-2145").
		 * productPrice(95000.0).productQuntity(2).manufacturerName("Asus").build();
		 * Product product4 =
		 * Product.builder().productName("OnePlus 12 pro").modelNumber("ONE0121").
		 * productPrice(75000.0).productQuntity(2).manufacturerName("BBK").build();
		 * Product product5 =
		 * Product.builder().productName("Vivo X100 Pro").modelNumber("VIN1452").
		 * productPrice(95000.0).productQuntity(2).manufacturerName("BBK").build();
		 * Product product6 =
		 * Product.builder().productName("Asus Rog 8 pro").modelNumber("ORG1452").
		 * productPrice(85900.0).productQuntity(2).manufacturerName("Asus").build();
		 * Product product7 =
		 * Product.builder().productName("Acer Nitro 5").modelNumber("AC56-80-95").
		 * productPrice(85000.0).productQuntity(2).manufacturerName("Acer").build();
		 * Product product8 =
		 * Product.builder().productName("HP Omen 15").modelNumber("HP5765").
		 * productPrice(105000.0).productQuntity(2).manufacturerName("Hp").build();
		 * 
		 * 
		 * 
		 * 
		 * //invoke bulk injection method of service class
		 * service.saveAllProduct(List.of(product1, product2,
		 * product3,product4,product5,product6,product7,product8));
		     
		
		 //find by id 
		Product product1 = service.findProductById(105);
		System.out.println(product1);
		
		
		// fetch products
		List<Product> allProducts = service.findAllProducts();
        
		 allProducts.forEach(System.out::println);
		 
		 
		
		//update 
		
		 Product product = Product.builder().productId(103).productName("Samsung Galexy S23 Ultra ").modelNumber("SMT-23-01").productPrice(115000.0).productQuntity(2).manufacturerName("Samsung").build();
		
		service.updateProduct(product);
		*/
		
		
		
	}

}
