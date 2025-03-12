package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private Integer userId;
    private String firstName;
    private String lastName;
    private Long  contactNumber;
    private String emailId;
    private String  address;
}
