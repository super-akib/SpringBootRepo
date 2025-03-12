package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ActorsDao;
import com.demo.model.Actor;
@Service
public class ActorsService implements IActorsService 
{   
	@Autowired
	private ActorsDao actorsDao;
    
	@Override
	public List<Actor> getAllActors()
	{   
		List<Actor> allActors = null;
		
		 allActors = actorsDao.getAllActors();
		 if(allActors == null)
		 {
			 throw new NullPointerException("List collection object is null");
		 }
		return allActors;
	}

	@Override
	public Actor getActorById(int id) 
	{
		
		return null;
	}

	@Override
	public void addActor(Actor actor){
		
		
	}

	@Override
	public void updateActor(Actor actor) {
		
		
	}

	@Override
	public void deleteActor(int id) {
		
		
	}

	@Override
	public Actor getActor(String actorName) {
		
		return null;
	}
	
}
