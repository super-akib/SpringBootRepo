package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entity.UserData;

public interface IUserRegistrationRepository extends JpaRepository<UserData, Integer> 
{
    //find user record based on there emailID 
	@Query("from UserData where emailId=?1")
	UserData findByEmail(String emailId);
}
