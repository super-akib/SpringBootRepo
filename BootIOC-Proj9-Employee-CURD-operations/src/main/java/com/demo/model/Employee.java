package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee 
{   
	//Employee class properties
     private Integer employeeId;
     private String employeName;
     private String designation;
     private Double  employeeSalary;
     private String departmentName;
}
