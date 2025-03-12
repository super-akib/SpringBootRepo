package com.demo.runner;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.Product;
import com.demo.service.ProductService;

@Component
public class ProductRunner implements CommandLineRunner {
	@Autowired
	private ProductService service;

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("\n=================<Product-Management-System>=========");
			System.out.println("1.Add product details.");
			System.out.println("2.Get Product details based on productId.");
			System.out.println("3.Update existing product into new product.");
			System.out.println("4.Delete existing product details from database.");
			System.out.println("5.Get all products details from database.");
			System.out.println("6.Exit.\n");
			System.out.println("===================<Select-Option>===================");

			// get the option from given option list
			System.out.print("Enter option number:");
			Integer option = scan.nextInt();

			// assign the option variable to switch case

			switch (option) {
			case 1:
				System.out.print("Enter product Id:");
				Integer productId = scan.nextInt();

				System.out.print("Enter product Name:");
				String productName = scan.nextLine();
				productName = scan.nextLine();

				System.out.print("Enter product price :");
				Double price = scan.nextDouble();

				System.out.print("Enter product Quantity:");
				Integer quantity = scan.nextInt();

				// create product object using builder
				Product product = Product.builder().productId(productId).productName(productName).productPrice(price)
						.productQuantity(quantity).build();

				System.out.println("===================<Output>==================\n");
				// invoke addProduct method of service class
				service.addProduct(product);

				break;

			case 2:
				System.out.print("Enter product Id:");
				Integer proId1 = scan.nextInt();

				System.out.println("===================<Output>==================\n");
				// invoke getProductById method of service class
				Product product2 = service.getProduct(proId1);
				// print the product data
				System.out.println(product2);

				break;
			case 3:
				System.out.print("Enter existing product Id:");
				Integer proId2 = scan.nextInt();

				System.out.print("Enter new product Name:");
				// Solved Buffer issue
				String newProductName = scan.nextLine();
				newProductName = scan.nextLine();

				System.out.print("Enter new product price:");
				Double newPrice = scan.nextDouble();

				System.out.print("Enter new product quantity:");
				Integer qty = scan.nextInt();
				Product product1 = Product.builder().productId(proId2).productName(newProductName)
						.productPrice(newPrice).productQuantity(qty).build();

				System.out.println("===================<Output>==================\n");
				// invoke updateProduct method of service class
				service.updateProduct(product1);
				break;

			case 4:
				System.out.print("Enter product id which we want to delete:");
				Integer proId3 = scan.nextInt();

				System.out.println("===================<Output>==================\n");
				// invoke deleteProduct method of service class
				service.deleteProduct(proId3);

				break;
			case 5:
				System.out.println("===================<Output>==================\n");
				List<Product> allProducts = service.getAll();
				// Fetch one by one product object from collection list
				for (Product product3 : allProducts) {
					System.out.println(product3);
				}
				break;

			case 6:
				scan.close();
				System.exit(0);

			default:
				System.err.println(" ! Invalid Option try again ..");
			}

		}

	}

}
