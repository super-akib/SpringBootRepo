package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.Employee;
//Employee repository interface extends to pre-define repository interface
public interface IEmployeeRepository extends CrudRepository<Employee, Integer> 
{

}
