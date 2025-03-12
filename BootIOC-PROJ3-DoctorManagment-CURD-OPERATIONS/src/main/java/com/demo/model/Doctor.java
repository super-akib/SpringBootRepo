package com.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Doctor 
{ 
	//Doctor class properties
	private Integer doctorId;
	private String doctorName;
	private String specialization;
	private Double salary;
	private String department;

}
