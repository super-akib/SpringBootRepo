package com.demo.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {
	private String employeeName;
	private String designation;
	private Double salary;
	private String address;
	private String emailId;
	private Long phoneNumber;
	private String status;
}
