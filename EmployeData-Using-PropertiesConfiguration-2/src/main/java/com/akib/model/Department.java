package com.akib.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("department")
public class Department
{
   private String departmentId;
   private String departmentName;
   
}
