package com.demo.service;

import com.demo.entity.Student;

public interface IStudentManagementService 
{
    //Save method for both student and course entities 
	String  saveStudentAndCourseRecord(Student student);
	
	//find student record by there id
	Student findByStudentId(Integer studentId);
}
