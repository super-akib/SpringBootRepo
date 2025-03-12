package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.model.Employee;

@SpringBootTest
class BootIocTestEmployeeProj2ApplicationTests {

	
	Employee emp = new Employee();
	
	
	//test setter and getter methods
	@Test
	public void setEmployeeIdTest()
	{    
		 //set the values
		  emp.setEmployeeId(101);
		  //test actual result matched with expected result
		 Assertions.assertEquals(101, emp.getEmployeeId());    
	}
	
	@Test
	public void setEmployeeNameTest()
	{
		emp.setEmployeeName("akib");
		//test actual result matched with expected result
		Assertions.assertEquals("akib", emp.getEmployeeName());
	}
	@Test
	public void setSalaryTest()
	{
		emp.setSalary(45000.0d);
		//test actual result matched with expected result
		Assertions.assertEquals(45000.0d, emp.getSalary());
	}
	@Test
	public void setDesignationTest()
	{
		emp.setDesignation("Developer");
		
		Assertions.assertEquals("Developer", emp.getDesignation());
	}

	//getter methods test
	
	@Test
	public void getEmployeeIdTest()
	{
	      emp.setEmployeeId(101);
	      Integer actual = emp.getEmployeeId();
	      Integer expected = 101;
	      //test getter 
	      Assertions.assertEquals(expected, actual);
	      
	      
	}
	
	@Test
	public void getEmployeeNameTest()
	{
		emp.setEmployeeName("akib");
		
		String actual = emp.getEmployeeName();
		
		String expected = "akib";
		
		Assertions.assertEquals(expected, actual);
		
		
	}
	@Test
	public void getSalaryTest()
	{
		    emp.setSalary(40000.0);
		Double actual = emp.getSalary();
		Double expected = 40000.0;
		
		Assertions.assertEquals(expected, actual);
	}
	@Test
	public void getDesignationTest()
	{
		emp.setDesignation("Developer");
		String actual = emp.getDesignation();
		String expected = "Developer";
		Assertions.assertEquals(expected, actual);
	}
	
    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    public void setIdExceptionTest( Integer id)
    {
    	   Assertions.assertThrows(IllegalArgumentException.class,()->emp.setEmployeeId(id),"Invalid id .please enter positive and grater than 0 values.");
    }
	
    @ParameterizedTest
    @ValueSource(doubles = {0,-1})
    public void setSalaryExceptionTest(Double salary)
    {
    	Assertions.assertThrows(IllegalArgumentException.class,()->emp.setSalary(salary),"0 or Negative vlues not allowed");
    }
}
