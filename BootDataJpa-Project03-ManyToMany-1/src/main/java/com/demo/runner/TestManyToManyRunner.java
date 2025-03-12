package com.demo.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Course;
import com.demo.entity.Student;
import com.demo.service.IStudentManagementService;
@Component
public class TestManyToManyRunner implements CommandLineRunner {

	@Autowired
	private IStudentManagementService  service;
	
	@Override
	public void run(String... args) throws Exception
	{
		
		//Create course class objects
		Course course1 = Course.builder().courseName("Java Full stack").abbrivation("JAVA").coruseFee(30000.0).modules(12).courseTitle("Java Full stack Placement Program").build();
		Course course2 = Course.builder().courseName("Python Full stack").abbrivation("Python").coruseFee(25000.0).modules(9).courseTitle("Java Full stack Placement Program").build();
		Course course3 = Course.builder().courseName("UI Full Stack").abbrivation("Marne").coruseFee(15000.0).modules(4).courseTitle("UI full stack Non placement").build();
		Course course4 = Course.builder().courseName("Data Science").abbrivation("Python").coruseFee(8500.).modules(5).courseTitle("Data science using python").build();
		
	      //create student class objects 
		Student student1 = Student.builder().studentName("Jhon").studentAge(23).studentGrade('A').courses(Set.of(course1,course3)).build();
		
		/*
		 * //invoke service save method String record =
		 * service.saveStudentAndCourseRecord(student1); System.out.println(record);
		 */
		//fetch student record based on there id
		Student fetchedStudent = service.findByStudentId(1);
		
		System.out.println(fetchedStudent);
		fetchedStudent.getCourses().forEach(System.out::println);
   
	}

}
