package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Employee;

public interface IEmployeeManagementService
{
     Page<Employee> showEmployeesByPagination(Pageable pageable);
     
     String registerEmployee(Employee employee);
     
     String editEmployeeById(Employee employee);
}
