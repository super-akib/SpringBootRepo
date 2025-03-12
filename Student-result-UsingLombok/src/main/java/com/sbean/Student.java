package com.sbean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("student")
@Scope("prototype")
public class Student
{
    private int studentId ;
    private String studentName;
    private int marks;
    private String result;
}
