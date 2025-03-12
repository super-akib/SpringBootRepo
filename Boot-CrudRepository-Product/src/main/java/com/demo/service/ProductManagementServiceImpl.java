package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.repository.IProductManagementRepository;
@Service
public class ProductManagementServiceImpl implements IProductManagementService {

	//Field level injection Has-a property of repository interface
	@Autowired
	private IProductManagementRepository  productRepository;
	
	//Search product based on product id
	@Override
	public Product findProductById(Integer productId) 
	{   
		//verify the product id is positive or not 
		if(productId <=0) 
		{
			throw new IllegalArgumentException("Product Id can not be Zero/Negative");
		}
		else
		{	// if product is available then it will return product object / throw exception		
			return  productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException(productId+" id Product not founded."));
		}
	}

	
	//Fetch all product records 
	@Override
	public List<Product> findAllProducts() 
	{
		//invoke findAll repository method 
		List<Product> allProducts =(List<Product>) productRepository.findAll();
		
		if(allProducts.isEmpty())
		{
			throw new IllegalArgumentException("Products data not available in database.");
		}
		else
		{
			return allProducts;			
		}
	}

	
	//Insert operation  
	@Override
	public void saveProduct(Product product) 
	{   
		//verify product object is null or not
		if(product == null)
		{
			throw new NullPointerException("In these case product object can not be null");
		}
		else
		{
			// invoke save method of repository
			Product save = productRepository.save(product);
			if(save !=null)
			{
				System.out.println("Product "+product.getProductId()+" sucessfully registrated.");
			}
			else
			{
				throw new IllegalArgumentException("Porduct can not be register.");
			}
		}

	}

	//Bulk injection of products 
	@Override
	public void saveAllProduct(List<Product> list) {
         
		//verify list collection is null or not
		if(list.isEmpty())
		{
			throw new NullPointerException("Bulk injection faild due to list collection is Empty.");
		}
		else
		{
			//invoke saveAll method of repository class
			List<Product> allSaved =(List<Product>) productRepository.saveAll(list);
			
			if(allSaved.isEmpty())
			{
				throw new IllegalArgumentException("Products data can not be stored.");
			}
			else
			{
				System.out.println(allSaved.size()+" products sucessfully stored in database.");
			}
		}
	}

	// Update existing product data to  new one
	@Override
	public void updateProduct(Product newProduct) {
		
		if(newProduct ==  null)
		{
			throw new NullPointerException("In these case we can not  pass null object.");
		}
		else
		{
		    Optional<Product> product = productRepository.findById(newProduct.getProductId());
		    
		    if(product.isPresent())
		    {
		    	productRepository.save(newProduct);
		    }
		    else
		    {
		    	throw new IllegalArgumentException("Product id:"+newProduct.getProductId()+"  is not founded.");
		    }
		}

	}
      //delete product based on there id
	@Override
	public void deleteProductById(Integer productId)
	{ 
		
		Optional<Product> product = productRepository.findById(productId);
    
    if(product.isPresent())
    {
    	productRepository.deleteById(productId);
    	System.out.println("Product "+productId+" sucesfully deleted.");
    }
    else
    {
    	throw new IllegalArgumentException("Product id:"+productId+"  is not founded.");
    }
	}
     

	//It will delete hole data 
	@Override
	public void deleteAllProducts() {
		
		productRepository.deleteAll();
	    System.out.println("All records delete from table");
	}

}
