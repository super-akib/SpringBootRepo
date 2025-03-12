package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bindings.EmployeeInfo;
import com.demo.service.IEmployeeServiceManagement;
@RestController
@RequestMapping("/emp-api")
public class EmployeeRestController
{  
   @Autowired	
   private IEmployeeServiceManagement employeeService;
   
   @PostMapping("/save")
   public String saveEmployee(@RequestBody EmployeeInfo employee)
   {
	  System.out.println("EmployeeRestController.saveEmployee()");
	 return employeeService.saveEmployeeData(employee);
   }
   @PostMapping("/show-all")
   public ResponseEntity<List<EmployeeInfo>> showAllEmployee()
   {   
	   List<EmployeeInfo> list = employeeService.findAllEmployee();
	   return new ResponseEntity<List<EmployeeInfo>>(list,HttpStatus.FOUND); 
    }
}
