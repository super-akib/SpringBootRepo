package com.demo.service;

import java.util.List;

import com.demo.entity.User;

public interface IUserManagementService 
{
     String saveUserData(User user);
     User  getUserById(Integer userId);
     List<User> getAllUserData();
     String deleteUserDataById(Integer userId);  
    
}
