package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface IProductService 
{
   void addProduct(Product product);
   
   List<Product> getAll();
   
   Product getProduct(Integer productId);
   
   void updateProduct(Product product);
   
   void deleteProduct(Integer productId);
}
