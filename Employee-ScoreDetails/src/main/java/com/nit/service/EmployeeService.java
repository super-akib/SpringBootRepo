package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.sbean.Employee;
import com.nit.sbean.EmployeeReviewSave;

@Service
public class EmployeeService
{ 
	@Autowired
    private EmployeeReviewSave saveReview;
	
	public void evaluateEmployeePerformance(Employee emp)
	{
		try 
		{
			 if(emp.getScore()<=100 && emp.getScore()>80)
			 {
				  emp.setReviewScore("excellent");
			 }
			 else  if(emp.getScore()<=80 && emp.getScore()>=50)
			 {
				 emp.setReviewScore("satisfactory");
			 }
			 else if(emp.getScore()<50 && emp.getScore() >=0)
			 {
				 emp.setReviewScore("needsImprovement");
			 }
			 else
			 {
				 throw new IllegalArgumentException("Invalid Score. Please put 0 to 100 only");
			 }
			 //Invoke the addEmployeeReview method
			 saveReview.addEmployeeReview(emp);
		} 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	 
	public void review()
	{
		//excellent list
		
		for (Employee employee : saveReview.getExcellent())
		{
			 System.out.println(employee);
		}
		
		//satisfactory list
		for (Employee employee :saveReview.getSatisfactory() )
		{
		   System.out.println(employee);
		}
		
		//needsImprovement list
		for (Employee employee : saveReview.getNeedsImprovement())
		{
		    System.out.println(employee);
		}
				
	}
}
