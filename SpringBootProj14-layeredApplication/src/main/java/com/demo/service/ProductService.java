package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;
@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public void addProduct(Product product)
	{
		productDao.addProducts(product);
	}

	@Override
	public List<Product> getAll() 
	{
	     List<Product> list = null;
	     
	     list = productDao.getAllProducts();
	     
	     if(list == null)
	     {
	    	 throw new NullPointerException("List collection object cannot be null");
	     }
		return list;
	}

	@Override
	public Product getProduct(Integer productId) 
	{
		Product product = null;
		if(productId <=0)
		{
			throw new  IllegalArgumentException("Can not pass zero/-ve negative values ");
		}
		else
		{
			 product = productDao.getProductById(productId);
		}
		return product;
	}

	@Override
	public void updateProduct(Product product) 
	{

		 if(product == null)
		 {
			 throw new NullPointerException("Product properties can not be null");
		 }
		 else
		 {
			 productDao.updateProducts(product);
		 }

	}

	@Override
	public void deleteProduct(Integer productId) {
		
		if(productId <=0)
		{
			throw new  IllegalArgumentException("Can not pass zero/-ve negative values ");
		}
		else
		{
			productDao.deleteProductById(productId);
		}

	}

}
