package com.sbean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	@Autowired
	private StudentDataSave save;

	public void addStudentResult(Student student) {
		if (student.getMarks() <= 60 && student.getMarks() >=0) {
			student.setResult("fail");

			// invoke addStudent method
			save.addStudentData(student);
		}
		else if(student.getMarks()<=100 && student.getMarks()>60) 
		{
			student.setResult("pass");
			// invoke addStudent method
			save.addStudentData(student);
		}
		else
		{
			throw new IllegalArgumentException("Invalid marks please put upto 100 only.");
		}

	}

	// print all details
	public void ShowDetails() {
		System.out.println("-------------Passed-Students-List-----------------");
		ArrayList<Student> pass = save.getPass();
		for (Student student : pass) {
			System.out.println(student);
		}
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println("-------------Faild-Students-List-----------------");
		ArrayList<Student> fail = save.getFail();

		for (Student student : fail)
		{
			System.out.println(student);
		}
		System.out.println("-------------------------------------------------");
	}
}
