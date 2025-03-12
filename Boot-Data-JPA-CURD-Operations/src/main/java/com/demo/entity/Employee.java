package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Employee_record_info")
public class Employee {
	@Id
	@SequenceGenerator(name = "myseq" , sequenceName = "seq_id" ,initialValue = 100 , allocationSize = 1  )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "myseq")
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "employee_name")
	@NonNull
	private String employeeName;
	@Column(name = "email")
	@NonNull
	private String employeeEmail;
	@Column(name = "department_name")
	@NonNull
	private String departmentName;
}