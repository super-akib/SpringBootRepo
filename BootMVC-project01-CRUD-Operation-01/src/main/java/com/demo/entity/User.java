package com.demo.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name="user_mvc_record")
public class User
{
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private Integer id;
   @NonNull
   @Column(name = "user_name", length = 120 , nullable = false ,unique = true)
   private String userName;
   @NonNull
   @Column(name = "email_id" ,nullable = false ,unique = true)
   private String emailId;
   @NonNull
   @Column(name = "contact_number",nullable = false ,unique = true)
   private Long   contactNumber;
   @NonNull
   @Column(name = "address")
   private String address;
}
