package com.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.service.ISeasonFinderService;

@Controller
public class SeasonFinderController
{
     
	  private final ISeasonFinderService seasonService;
     
      public SeasonFinderController(ISeasonFinderService seasonService)
      {
		super();
		this.seasonService = seasonService;
	  }

	//Handler method for home page
     @GetMapping("/home")
     public String showHomePage()
     {
    	 return "home";
     }
     
     @GetMapping("/season")
     public String showSeason(Map<String,Object> map)
     {  
    	 //get season from service class method
    	 String resultMassage = seasonService.seasonFinder();
    	 
    	 //set Map property
    	 map.put("message", resultMassage);
    	 //return LVN
    	 return"season";
     }
}
