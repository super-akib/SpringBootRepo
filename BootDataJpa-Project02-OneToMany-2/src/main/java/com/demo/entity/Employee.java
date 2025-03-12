package com.demo.entity;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "JPA_Employee_Record")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer employeeId;
	@NonNull
	@Column(name = "emp_name")
	private String employeeName;
	@NonNull
	@Column(name = "email_Id")
	private String emailId;
	@NonNull
	@Column(name = "ph_number")
	private Long phoneNumber;
	@NonNull
	@Column(name = "Address")
	private String employeeAddress;
	@NonNull
	@Column(name = "work_location")
	private String workLocation;

	@NonNull
	@Column(name = "Salary")
	private Double salary;
	//Join relationship between User define and predefine class
	@ElementCollection
	@CollectionTable(name="technology_recods_info" , joinColumns = @JoinColumn(name="tech_id", referencedColumnName = "emp_id"))
	private Set<String> technologies;
	//join between two  user define classes 
	@OneToMany(mappedBy = "employee")
	private Set<Department> listOfDepartment;

	// generate to string
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", employeeAddress=" + employeeAddress + ", workLocation="
				+ workLocation + "]";
	}

}
