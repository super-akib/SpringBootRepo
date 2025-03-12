package com.nit.sbean;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component("save")
@Getter
public class EmployeeReviewSave 
{
	private ArrayList<Employee> excellent = new ArrayList<>();
	private  ArrayList<Employee> satisfactory = new ArrayList<>();
	private ArrayList<Employee>  needsImprovement = new ArrayList<>();
	
	public void addEmployeeReview(Employee employee)
	{
		try {
			 if(employee.getReviewScore().equalsIgnoreCase("excellent"))
			 {
				 excellent.add(employee);
			 }
			 else if(employee.getReviewScore().equalsIgnoreCase("satisfactory"))
			 {
				 satisfactory.add(employee);
			 }
			 else 
			 {
				 needsImprovement.add(employee);
			 }
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
