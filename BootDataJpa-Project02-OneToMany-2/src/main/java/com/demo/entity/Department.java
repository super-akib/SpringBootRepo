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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "JPA_Department_info")


public class Department 
{    
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "dept_no")
    private Integer departmentId;
	@NonNull
	@Column(name = "department_name")
    private String departmentName;
    @ManyToOne
    @JoinColumn(name = "dept_no" , referencedColumnName = "emp_id")
    private Employee  employee;
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
    
    
}
