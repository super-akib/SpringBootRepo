package com.demo.dao;

import java.util.List;

import com.demo.model.Actor;

public interface IActorsDao
{
	List<Actor> getAllActors();
    Actor getActorById(int id);
    void addActor(Actor actor);
    void updateActor(Actor actor);
    void deleteActor(int id);
    Actor getActor(String actorName);
}
