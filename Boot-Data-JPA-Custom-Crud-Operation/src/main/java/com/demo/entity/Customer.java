package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "Customer_management")
public class Customer
{   
	@SequenceGenerator(name = "mySeq", sequenceName ="seqId", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "mySeq")
	@Column(name = "customer_id")
	@Id
    private Integer customerId;
    
	@Column(name = "First_name" , length = 100)
	@NonNull
	private String FirstName;
	
	@Column(name = "last_name", length = 100)
	@NonNull
	private String lastName;
	
	@Column(name = "email_id")
	@NonNull
	private String emailId;
	
	@Column(name = "phone_number" , length = 10)
	@NonNull
	private String phoneNumber;



}
