package com.nit.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Scope("prototype")
@Data
public class User
{
    private  int userId;
    private  String userName;
    private  String  emailId;
}
