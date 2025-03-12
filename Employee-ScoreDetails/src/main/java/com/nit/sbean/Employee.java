package com.nit.sbean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@Scope("prototype")
public class Employee
{
    private int employeeId;
    private String employeeName;
    private int score;
    private String reviewScore;
    
}
