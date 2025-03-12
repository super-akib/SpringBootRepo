package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface IStudentService 
{
    public String save(Student s);

	public List<Student> getAll();

	public Student FindByid(int id);
}
