package com.demo.service;

import java.util.List;

import org.hibernate.query.Page;

import com.demo.entity.Product;

public interface IProductManagementService 
{
     
	// bulk insertion operation
	void stroeProductsInfo(List<Product> productList);
	
	//pagination on product records
	Page getAllRecords(Integer pageNo,Integer pageSize);
	// get last page records
	Page getLastRecords(String lastRecord);
	
}
