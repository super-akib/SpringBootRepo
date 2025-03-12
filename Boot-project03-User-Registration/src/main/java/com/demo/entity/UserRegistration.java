package com.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_registration_info")
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_name", length = 60, unique = true ,nullable = false)
	private String userName;
	@Column(name = "password", length = 18,nullable = false)
	private String password;
	@Column(name = "email_id", unique = true,nullable = false)
	private String emailId;
	@Column(name = "date_of_birth",nullable = false)
	private LocalDate birthDate;
	@Column(name = "profession",nullable = false)
	private String profession;
}
