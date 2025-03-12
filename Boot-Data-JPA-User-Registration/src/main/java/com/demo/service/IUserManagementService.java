package com.demo.service;

import com.demo.dto.UserDto;
import com.demo.exception.UserCredentialException;

public interface IUserManagementService
{
    // user Registration business method 
    String userRegistration(UserDto user) throws UserCredentialException;
       
}
