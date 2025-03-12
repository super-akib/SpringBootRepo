package sbean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")
public class EmployeeService
{      
	  @Autowired
      private ArrayList<Employee> list;
	  
	  public void addIncrementSalary(Employee emp)
	  {   
		  double salary = emp.getSalary();
		  if(emp.getDepartment().equalsIgnoreCase("Hr"))
		  {   
			  salary += salary  * 0.1;
			  emp.setSalary(salary);
		  }
		  else if(emp.getDepartment().equalsIgnoreCase("Manager"))
		  {
			  salary += salary  * 0.3;
			  emp.setSalary(salary);			  
		  }
		  else if(emp.getDepartment().equalsIgnoreCase("Developer"))
		  {
			  salary += salary  * 0.5;
			  emp.setSalary(salary);			  
		  }
		  else if(emp.getDepartment().equalsIgnoreCase("TeamLeader"))
		  {   
			  salary += salary  * 0.7;
			  emp.setSalary(salary);			  
		  }
		  else
		  {
			  System.err.println("Invalide Department name");
		  }
		  
		  list.add(emp);
	  }
	  
	  //Print the all employee data
	  public void print()
	  {
		  for(Employee emp : list)
		  {
			  System.out.println(emp);
		  }
	  }
}
