package com.demo.service;

import java.util.List;

import com.demo.entity.Product;

//service class interface having common business methods 
public interface IProductManagementService {
	// retrieve product data based on there id
	Product findProductById(Integer productId);

	// retrieve all products
	List<Product> findAllProducts();

	// Save single product data
	void saveProduct(Product product);

	// save multiple products at a time
	void saveAllProduct(List<Product> list);

	// update product data
	void updateProduct(Product newProduct);

	// delete product based on there id
	void deleteProductById(Integer productId);

	// Empty product table
	void deleteAllProducts();

}
