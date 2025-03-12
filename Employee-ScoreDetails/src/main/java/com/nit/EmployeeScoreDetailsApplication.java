package com.nit;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.sbean.Employee;
import com.nit.service.EmployeeService;

@SpringBootApplication
public class EmployeeScoreDetailsApplication {

	public static void main(String[] args) 
	{
	  ApplicationContext context = SpringApplication.run(EmployeeScoreDetailsApplication.class, args);
	      	 
		 EmployeeService service = context.getBean(EmployeeService.class);
	     Scanner scan  = new Scanner(System.in);
	     while(true)
	     {
	    	 System.out.println("1.Add Employee Score.");
	    	 System.out.println("2.Show Employee Score.");
	    	 System.out.println("3.Exit.");
	    	 System.out.println("\n-----------------Option---------------");
	    	 System.out.println("Enter your Option:");
	    	 int option = scan.nextInt();
	    	 switch(option)
	    	 {
	    	    case 1:  
	    	    	    System.out.print("Enter Employee Id:");
	    	    	    int id = scan.nextInt();
	    	    	    System.out.print("Enter Employee Name:");
	    	    	    String name = scan.next();
	    	    	    System.out.print("Enter Employee Score:");
	    	    	    int score = scan.nextInt();
	    	    	    
	    	    	    Employee employee = context.getBean("emp", Employee.class);
	    	    	    
	    	    	    employee.setEmployeeId(id);
	    	    	    employee.setEmployeeName(name);
	    	    	    employee.setScore(score);
	    	    	    service.evaluateEmployeePerformance(employee);
	    	    	    System.out.println("Data added Sucessfully..");
	    	    	    break;
	    	    case 2: 
	    	    	     service.review();;
	    	    	     break;
	    	    
	    	    case  3: 
	    	    	     System.exit(0);
	    	    	     scan.close();
	    	    default :
	    	    	      System.err.println("Invalide option selected..");
	    	 }
	    	 
	    	 
	     }
	}

}
