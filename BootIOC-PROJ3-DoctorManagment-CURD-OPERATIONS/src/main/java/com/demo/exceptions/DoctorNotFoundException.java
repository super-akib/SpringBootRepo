package com.demo.exceptions;

public class DoctorNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DoctorNotFoundException(Integer id)
	{  	
	  System.err.println("No record found on this Id:"+id+" .Please  enter valid id");
	}

}
