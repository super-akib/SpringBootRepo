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

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "user_registration")
@Data
public class User
{    
	@SequenceGenerator(name = "userSeq" , sequenceName = "userSeq1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="userSeq" )
	@Id
	@Column(name = "user_id")
    private Integer userId;
	
	@NonNull
	@Column(name = "user_name")
	private String userName;
	
	@NonNull
	@Column(name = "first_name")
	private String firstName;
	
	@NonNull
	@Column(name = "last_name")
	private String lastName;
	
	@NonNull
	@Column(name = "email_id")
	private String emailId;
	
	@NonNull
	@Column(name = "password", length = 20)
	private String userPassword;
	
	@NonNull
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	
    
}
