package com.demo.service;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.repository.IProductManagementRepository;
@Service("productService")
public class ProductManagementServiceImpl implements IProductManagementService {
    
	//filed level injection and Has-a property of repository Interface
	@Autowired
	private IProductManagementRepository  productRepository;
	
	//Bulk injection business method
	@Override
	public void stroeProductsInfo(List<Product> productList)
	{
		if(productList.isEmpty())
		{
		 throw new IllegalArgumentException("In this case product list collection can not be null/empty.");
		}
		else
		{
			List<Product> saveAll = (List<Product>)productRepository.saveAll(productList);
		     
			if(saveAll == null)
			{
				throw new NullPointerException("Data can not be stored in database");
			}
			else
			{
				System.out.println(saveAll.size()+" products record are saved in database.");
			}
 	  	}

	}
     
	//get page records business method
	@Override
	public Page getAllRecords(Integer pageNo, Integer pageSize) 
	{
		//count number records in database
		Long countRecords = productRepository.count();
	    // count pages 
		Long countPages = countRecords/pageSize;
		// condition for if some  records size not match with given page size
		if(countRecords%countPages !=0)
		{
			countPages++;
		}
		System.out.println("Total Pages."+countPages);
		System.out.println("------------------------");
		
	    for(Integer i=pageNo;i<countPages;)
	    {
	    	
	    }
		return null;
	}

	//get last record of the last page
	@Override
	public Page getLastRecords(String lastRecords) {
		// TODO Auto-generated method stub
		return null;
	}

}
