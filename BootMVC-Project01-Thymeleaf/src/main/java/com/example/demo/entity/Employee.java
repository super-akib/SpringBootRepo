package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "emp_data_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee
{   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empNo;
    @NonNull
    @Column(name="emp_name",nullable =false)
    private String employeeName;
    @NonNull
    @Column(nullable =false)
    private String job;
    @NonNull
    private Double salary;
}
