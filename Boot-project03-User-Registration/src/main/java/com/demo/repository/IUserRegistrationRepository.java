package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.UserRegistration;

public interface IUserRegistrationRepository extends JpaRepository<UserRegistration, Integer> 
{
   //check user already registered or not
	@Query("select userName from UserRegistration where userName=?1 ")
	String findByUserName(String userName);
}
