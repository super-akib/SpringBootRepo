package com.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rest_employee_management")
public class EmployeeInfoEntity
{  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "empNo")
   private Integer employeeId;
   @Column(name = "name",length = 100) 
   private String employeeName;
   @Column(length = 100)
   private String designation;
   private Double salary;
   private String address;
   @Column(unique = true)
   private String emailId;
   @Column(unique = true)
   private Long   phoneNumber;
   private String status;
   //meta data about entity class
   @Value("${user.username}")
   @Column(insertable = false , updatable = true)
   private String  updatedBy;
   @Value("${user.username}")
   @Column(insertable = true, updatable = false)
   private String  createdBy;
   @CreationTimestamp
   @Column(insertable = true , updatable = false)
   private LocalDateTime createdDateTime;
   @UpdateTimestamp
   @Column(insertable = false , updatable = true)
   private LocalDateTime updatedDateTime;
   @Version
   @Column(insertable = false , updatable = true)
   private Integer countUpdation;
}
