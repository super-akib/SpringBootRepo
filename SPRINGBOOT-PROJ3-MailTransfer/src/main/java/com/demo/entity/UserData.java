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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "user_registration")
public class UserData
{
	@Id
	@SequenceGenerator(name ="user_seq" , sequenceName = "userSeq", initialValue = 100, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "user_name", length = 80)
	@NonNull
	private String userName;
	@NonNull
	@Column(name = "email_id", length = 100)
	private String emailId;
}
