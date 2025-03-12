package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
	//Student class properties
   private Integer studentId;
   private String studentName;
   private Integer studentMarks;
   private String  studentGrad;
   
}
