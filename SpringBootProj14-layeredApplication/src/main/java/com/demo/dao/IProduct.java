package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface IProduct
{
     
	void addProducts(Product product);
	List<Product>  getAllProducts();
	Product  getProductById(Integer productId);
	void updateProducts(Product product);
	void deleteProductById(Integer productId);
	
	
}
