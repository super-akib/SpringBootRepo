package com.akib.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("employee")
@ConfigurationProperties(prefix = "employee")
public class Employee 
{
	//properties of employee class
    private Integer employeeId;
    private String employeeName;
    private Double  salary;
    private List<String> skills;
    private List<Long> phoneNumber;
    //HAS-A relation properties and field level injection 
   
    @Autowired
    private Department  department;
    @Autowired
    private Address address;
    
    
	
}
