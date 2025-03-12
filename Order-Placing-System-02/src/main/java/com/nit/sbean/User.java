package com.nit.sbean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User 
{
   private  int  userId;
   private  String userName;
   private  String emailId;
   private  String address;
   

}
