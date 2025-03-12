package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "bank_employee_records")
public class Employee {   
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "emp_id")
    private Integer employeeId;

	@NonNull
	@Column(name = "employee_name")
    private String employeeName;

	@Column(name = "department_no")
    private Integer departmentNumber;

    @NonNull
    @Column(name = "department_name")
    private String departmentName;

    @NonNull
    @Column(name = "salary")
    private Double salary;
    
    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
    private Bank bank;

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", departmentNumber="
				+ departmentNumber + ", departmentName=" + departmentName + ", salary=" + salary + "]";
	}
}
