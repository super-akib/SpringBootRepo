package com.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Actor 
{
	//properties of Actor class
    private  Integer actorId;
    private String actorName;
    private String movieName;
    
}
