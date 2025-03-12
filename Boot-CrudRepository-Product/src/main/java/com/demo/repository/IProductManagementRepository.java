package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Product;
//repository interface 
public interface IProductManagementRepository extends CrudRepository<Product,Integer>
{
   
}
