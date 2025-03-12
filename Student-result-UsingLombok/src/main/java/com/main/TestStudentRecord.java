package com.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;
import com.sbean.Student;
import com.sbean.StudentService;

public class TestStudentRecord
{
     public static void main(String[] args)
     {
	     //Activate IOC container
    	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	 
    	 StudentService service = context.getBean(StudentService.class);
    	 Scanner scan = context.getBean("scan",Scanner.class);
    	 
    	 
    	 while(true)
    	 {
    		 System.out.println("1.Add Student Details:");
    		 System.out.println("2.Show All Passed/Faild Students List:");
    		 System.out.println("3.Exit.");
    		 
    		 System.out.println("Enter your option:");
    		 int option = scan.nextInt();
    		 
    		 switch(option)
    		 {
    		    case  1:  
    		    	Student student = context.getBean("student",Student.class);
    		    	System.out.print("Enter Student ID:");
    		    	int id = scan.nextInt();
    		    	System.out.print("Enter student Name:");
    		    	String name = scan.nextLine();
    		    	name = scan.nextLine();
    		    	System.out.print("Enter student marks:");
    		    	int marks = scan.nextInt();
    		    	
    		    	student.setStudentId(id);
    		    	student.setStudentName(name);
    		    	student.setMarks(marks);
    		    	
    		    	service.addStudentResult(student);
    		    	System.out.println("Student sucessfully added");
    		    	break;
    		    	     
    		    case  2: 
    		    	       service.ShowDetails();
    		    	       break;
    		    case  3:
    		    	      System.exit(0);
    		    	      scan.close();
    		    	      context.close();
    		 }
    	 }
	 }
}
