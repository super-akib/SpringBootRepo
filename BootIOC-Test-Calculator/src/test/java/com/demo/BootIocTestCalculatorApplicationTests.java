package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.service.CalculatorService;

@SpringBootTest
class BootIocTestCalculatorApplicationTests {
   
	
	@Test
    public void additionTest()
    {
//		int addition = new CalculatorService().additon(10, 20);
//		Assertions.assertEquals(30, addition);
      
		int addition = new CalculatorService().additon(10, 20);
		Assertions.assertEquals(30, addition);
    }
	
	@Test
	public void subtractionTest()
	{
		
//		int sub = new CalculatorService().subtraction(10, 20);
//		Assertions.assertEquals(-10, sub);

		int sub = new CalculatorService().subtraction(-10, 20);
		Assertions.assertEquals(-30, sub);
		
	}
	
	@Test
	public void multiplicationTest()
	{
		
		int mul = new CalculatorService().multiplication(-10, 20);
		Assertions.assertEquals(-200, mul);
	}
	@Test
	public void divisionTest()
	{
		
		float division = new CalculatorService().division(10, 5);
		Assertions.assertEquals(2, division);
	}
	

}
