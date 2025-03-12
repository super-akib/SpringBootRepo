package com.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.Actor;
import com.demo.service.ActorsService;

@Component
public class GetAllRecordRunner implements CommandLineRunner {
    
	@Autowired
	private ActorsService service;
	
	@Override
	public void run(String... args) throws Exception
	{
  	    List<Actor> allActors = service.getAllActors();
  	    
  	    for (Actor actor : allActors) {
			System.out.println(actor);
		}
        
 	}

}
