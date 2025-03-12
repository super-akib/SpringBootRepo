package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.entity.User;

public interface IUserManagementService {
	
	public String registerUser(User user);
	
	Page<User> paginationOfUser(Pageable pageable);
	
	User  findUserById(Integer id);
	
	String updateUserData(User user);
	
	String deleteUserById(Integer id);
	
}
