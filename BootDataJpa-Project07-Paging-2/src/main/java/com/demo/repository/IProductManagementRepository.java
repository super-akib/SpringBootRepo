package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.entity.Product;

public interface IProductManagementRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {

}
