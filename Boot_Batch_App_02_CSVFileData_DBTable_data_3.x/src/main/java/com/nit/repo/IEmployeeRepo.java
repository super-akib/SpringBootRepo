package com.nit.repo;

import org.springframework.data.repository.CrudRepository;

import com.nit.model.Employee;

public interface IEmployeeRepo  extends CrudRepository<Employee, Integer>
{

}
