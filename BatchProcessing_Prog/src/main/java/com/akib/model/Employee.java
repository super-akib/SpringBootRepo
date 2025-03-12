package com.akib.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "employee")
public class Employee {
	private Long employeeId;
	private String employeeName;
	private Double employeeSalary;
	private List<String> technology;
	private Set<Integer> mobile;
	private Map<String, Integer> idCard;
	
	@Autowired
	private Company employeeCompany;
}
