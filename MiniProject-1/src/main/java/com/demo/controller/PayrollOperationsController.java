package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.demo.model.Employee;
import com.demo.service.IEmployeeService;

@Controller("payroll")
public class PayrollOperationsController 
{ 
   @Autowired
   private IEmployeeService service;

   public List<Employee> showAllEmployeesByDesignation(String designation1,String designation2,String designation3)throws Exception
   {   
	   return  service.fetchAllEmployeeByDesignation(designation1, designation2, designation3);   
   }
}
