package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.model.Student;
import com.demo.service.StudentServiceImpl;

@SpringBootApplication
public class StudentDataMiniProject2Application {

	public static void main(String[] args) 
	{  
		//get IOC container 
		ApplicationContext context = SpringApplication.run(StudentDataMiniProject2Application.class, args);
		
		//get service class object from IOC container
		
		StudentServiceImpl service = context.getBean("studentService",StudentServiceImpl.class ); 
		
		//Inject the values in student model class using builder
		
		Student student = Student.builder().studentId(105).studentName("jonathen").studentMarks(35).build();
		
		//invoke service method saveData
		String saveData = service.saveData(student);
		System.out.println(saveData);
		
		//invoke service method getAll and fetch data from arrayList object that return the method
		for (Student std : service.getAll()) 
		{
			System.out.println(std);
	}
		
		//invoke service method findById 
		Student findByid = service.FindByid(102);
		System.out.println(findByid);
	
		//close IOC container
		((ConfigurableApplicationContext) context).close();
	} 

}
