package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Employee;

public interface IEmployeeManagementRepository  extends JpaRepository<Employee, Integer>
{

}
