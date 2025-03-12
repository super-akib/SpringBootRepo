package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="Data_jpa_employee_records")
public class Employee 
{
   @Id
   
   private Integer employeeId;
   @NonNull
   private String employeeName;
   @NonNull
   private Long   phoneNumber ;
   @NonNull
   private String  emailId;
   @NonNull
   private Double salary; 
   @NonNull
   private String jobPosition;
   @NonNull
   private String departmentName;
   @NonNull
   private String departmentNumber;
}
