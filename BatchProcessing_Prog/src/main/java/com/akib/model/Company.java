package com.akib.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix ="company")
@Component()
public class Company
{
    private Integer companyId;
    private String companyName;
    private String companyLocation;
    
	 
}
