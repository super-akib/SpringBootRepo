package com.demo.runner;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Employee;
import com.demo.service.IEmployeeService;
@Component
public class TestCrudRepositoryOperation implements CommandLineRunner {
  
	@Autowired
	private IEmployeeService employeeService;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		//take scanner class object for insert values dynamically 
		Scanner scan = new Scanner(System.in);
		
		 //take infinite while loop for dynamically value passing
		while(true)
		{
			System.out.println("\n================<Employee-Management-System>===============\n");
			System.out.println("1.Save employee recortd.");
			System.out.println("2.Get employee record by employeeId.");
			System.out.println("3.Update employee record by Id.");
			System.out.println("4.Delete Employee record by Id.");
			System.out.println("5. Get all employee records.");
			System.out.println("6.Exit.");
			System.out.println("===========================================================\n");
			//select options
			System.err.print("\nEnter your option:");
			Integer option = scan.nextInt();
			
			//Use switch case to perform multiple CURD operations
			switch(option)
			{
			    case 1: //set run time values to variables
			    	    System.out.print("Enter Employee Name:");
			    	    String name = scan.nextLine();
			    	           name = scan.nextLine();
			    	    System.out.print("Enter employee email:");
			    	    String email = scan.next();
			    	    System.out.print("Enter department name:");
			    	    String departmentName = scan.nextLine();
			    	           departmentName = scan.nextLine();

			    	   
			    	    // create employee class object reference
			    	    Employee employee = Employee.builder().employeeName(name).employeeEmail(email).departmentName(departmentName).build();
			    	    
			    	    //invoke service save class method 
			    	    employeeService.saveEmployeeData(employee);
			    	    
			           break; 	   
			    case 2: 
			    	       System.out.print("Enter employee id:");
			    	       Integer empId = scan.nextInt();
			    	       
			    	       //invoke findByid method of service class
			    	       Employee employee1 = employeeService.findById(empId);
			    	       
			    	       //print employee record
			    	       System.out.println(employee1);
			    	break; 
			    	
			    case 3:
			    	      //set run time values to variables
			    	       System.out.print("Enter employee id to Update existing employee record:");
			    	       Integer empId1 = scan.nextInt();
		    	           System.out.print("Enter Employee Name:");
		    	           String updateName = scan.nextLine();
		    	           name = scan.nextLine();
		    	           System.out.print("Enter employee email:");
		    	           String updaEmail = scan.next();
		    	           System.out.print("Enter department name:");
		    	           String updaDepartmentName = scan.nextLine();
		    	   
		    	    // create employee class object reference
		    	    Employee employee2 = Employee.builder().employeeId(empId1).employeeName(updateName).employeeEmail(updaEmail).departmentName(updaDepartmentName).build();
		    	         
		    	        //Invoke update method of service class
		    	       employeeService.updateEmployeeById(employee2);
		    	       
			    	break; 
			    	
			    case 4:  //set run time values to variables
		    	       System.out.print("Enter employee id to delete employee record:");
		    	       Integer empId2 = scan.nextInt();
		    	       
		    	       //invoke delete method of service class
		    	       employeeService.deleteEmployeeById(empId2);
			    	      
			    	break; 	   
			    case 5: 
			    	     //invoke getAll method of service class to get all employee records from table
			    	      List<Employee> allEmployee = employeeService.getAllEmployee();
			    	      
			    	      //using static method reference to print the given list collection  
			    	      allEmployee.forEach(System.out::println);
			    	break; 	   
			    case 6: 
			    	    //close scanner resources
			    	    scan.close();
			    	    //terminate infinite while loop
			    	    System.exit(0);
			    	break; 	   
			    default :  
			    	      System.err.println("Invalid Option chose right one .");
			}  
		}

	}

}
