package com.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto
{
    private String userName;
    private String firstName;
    private String lastName;
    private String emailId;
    private String confirmEmailId;
    private String userPassword;
    private String confirmUserPassword;
    private String phoneNumber;
    
}
