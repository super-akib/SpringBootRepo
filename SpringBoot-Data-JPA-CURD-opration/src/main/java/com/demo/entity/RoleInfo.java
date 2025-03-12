package com.demo.entity;

public enum RoleInfo 
{
   BATSMAN("lefty"),
   BOWLAR("Spinner") ,
   ALLROUNDER,
   WICKETKEEPER("eleven");
	
	String role;
	private RoleInfo(String s) 
	{
		role=s;
	}
	private RoleInfo()
	{
		
	}
  
}
