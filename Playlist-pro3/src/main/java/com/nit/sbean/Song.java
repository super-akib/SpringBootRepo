package com.nit.sbean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder	
public class Song 
{
    private Integer songId;
    private String songTitle ;
    private String artistName;
}
