package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface IEmployeeService 
{
    public  List<Employee> fetchAllEmployeeByDesignation(String designation1,String designation2,String designation3)throws Exception;
}
