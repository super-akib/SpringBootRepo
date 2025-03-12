package com.sbean;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.Getter;
@Getter
@Component
public class StudentDataSave {
  
	private ArrayList<Student> pass = new ArrayList<>();
	private ArrayList<Student> fail = new ArrayList<>();
	
	
	public void addStudentData(Student student)
	{
		if(student.getResult().equalsIgnoreCase("pass"))
		{
			pass.add(student);
		}
		else
		{
			fail.add(student);
		}
	}
}
