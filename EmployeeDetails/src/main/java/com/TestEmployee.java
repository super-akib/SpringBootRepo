package com;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import sbean.Employee;
import sbean.EmployeeService;

public class TestEmployee 
{
     public static void main(String[] args) {
		
    	Scanner scan = new Scanner(System.in); 
    	 //create IOC container
    	AnnotationConfigApplicationContext  context= new AnnotationConfigApplicationContext(AppConfig.class);
	      
        //get the EmployeeService class object from IOC container  
          EmployeeService service = context.getBean("service", EmployeeService.class);
          
          
          
        while(true)
        {
             Employee employee = new Employee(); 	
          System.out.println("1.Enter employee details in list.");
          System.out.println("2.Show all employee details list.");
          System.out.println("3.exit.");
          System.out.println("----------------------------------");
          
          System.out.print("Enter your option:");
          int option = scan.nextInt();
          
          System.out.println("------------------OutPut-----------------");
          switch(option)
          {
             case 1: System.out.print("Enter employee id:");
                     int empId = scan.nextInt();
                     System.out.print("Enter employee name:");
                     String name = scan.nextLine();
                            name = scan.nextLine();
                     System.out.print("Enter department Name:");
                     String department = scan.next();
                     System.out.print("Enter salary:");
                     double salary = scan.nextDouble();
                     //assign data  employee class properties
                     employee.setId(empId);
                     employee.setName(name);
                     employee.setDepartment(department);
                     employee.setSalary(salary);
                     
                     service.addIncrementSalary(employee);
                     System.out.println("Employee Details field sucessfully");
                     
                     break;
            
             case 2:   
            	         service.print();
            	         break;
             
             case  3: System.exit(0);
                      context.close();
                      scan.close();
                      break;
            
             default :  
            	        System.err.println("Invalide Option try again");
            	                       
          }
        }  
          
     }
}
