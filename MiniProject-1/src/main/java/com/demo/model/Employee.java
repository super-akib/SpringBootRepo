package com.demo.model;

import lombok.Data;

@Data
public class Employee 
{
    private Integer employeeNo;
    private String employeeName;
    private String employeeJob;
    private Double salary;
    private Integer departmentNo;
}
