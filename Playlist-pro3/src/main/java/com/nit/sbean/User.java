package com.nit.sbean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User 
{
    private Integer userId;
    private String userName;
    private String emailId; 
}
