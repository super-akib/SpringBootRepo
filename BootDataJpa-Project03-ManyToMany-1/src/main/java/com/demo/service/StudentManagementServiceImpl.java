package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Student;
import com.demo.repository.IStudentRepositoty;
@Service
public class StudentManagementServiceImpl implements IStudentManagementService {
 
	@Autowired
	private IStudentRepositoty  studentRepositoty;
	//business method for save operation
	@Override
	public String saveStudentAndCourseRecord(Student student) 
	{
		//validate student object in null or not
		if(student == null)
		{
			throw new NullPointerException("In these case student object can  not be null.");
		}
		else
		{
			return studentRepositoty.save(student).getStudentId()+" Student sucessfully registered.";
		}
	}
	@Override
	public Student findByStudentId(Integer studentId) 
	{   
        if(studentId<=0)
        {
        	throw new IllegalArgumentException("Can not be allowed 0 and negative values. .");
        }
        else
        {
        	return studentRepositoty.findById(studentId).orElseThrow(()-> new IllegalArgumentException("Record not found based on given id:"+studentId));
        }
		
	}
	
	

}
