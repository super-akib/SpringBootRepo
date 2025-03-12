package com.demo.service;

public class CalculatorService 
{
    
	
	public int additon(int number1 , int number2)
	{
		if(number1<=0 || number2 <=0 ) {
			throw new RuntimeException("number not accepetd lees tehn 0");
		}
	   return number1+number2;
	}
	public int subtraction(int number1 , int number2)
	{
		return number1-number2;
	}
	public int multiplication(int number1 , int number2)
	{
//		if(number1<=0 || number2 <=0 ) {
//			throw new RuntimeException("number not accepetd lees tehn 0");
//		}
		return number1*number2;
	}
	public float division(float number1 , float number2)
	{
//		if(number1<=0 || number2 <=0 ) {
//			throw new RuntimeException("number not accepetd lees tehn 0");
//		}
		return number1/number2;
	}
	
}
