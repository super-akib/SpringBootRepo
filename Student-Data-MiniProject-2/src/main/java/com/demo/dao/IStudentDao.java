package com.demo.dao;

import java.util.List;

import com.demo.model.Student;

public interface IStudentDao
{
	 //Abstract methods 
	 public String saveData(Student student);

	 public List<Student> getAll();

	 public Student FindByid(int id);


}
