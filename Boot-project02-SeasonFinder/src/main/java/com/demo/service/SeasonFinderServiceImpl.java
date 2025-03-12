package com.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class SeasonFinderServiceImpl implements ISeasonFinderService {
  
	//Business method for season finding
	@Override
	public String seasonFinder()
	{    
		//get current date from localDate class
       	LocalDate  localDate = LocalDate.now();
       	//get current month integer value and store in integer
       	Integer monthNumber = localDate.getMonthValue();
       	//store month name in these variable
       	String seasonName ="";
       	
       	//Check  current season based on there months
       	if(monthNumber >=3 && monthNumber<=5)
       	{
       		seasonName +="Summar Season";
       	}
       	else if(monthNumber >=6 && monthNumber<=10)
       	{
       		seasonName +="Rainy Season";
       	}
       	else 
       	{
       		seasonName +="Winter Season";
       	}
		return seasonName;
	}

}
