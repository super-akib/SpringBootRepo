package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.demo.model.Actor;

@Repository("actorDao")
public class ActorsDao implements IActorsDao {
	
	// Database perform  queries properties
	private static final String RETRIEVE_ALL_ACTORS = "SELECT * FROM ACTORS_RECORD";
	private static final String GET_ACTOR_BY_ID = "SELECT * FROM ACTORS_RECORD WHERE ACTOR_ID=?";
	private static final String ADD_ACTOR_RECORD = "INSERT INTO ACTORS_RECORD VALUES(?,?,?)";
	private static final String UPDATE_ACTOR_BY_ID = "UPDATE ACTORS_RECORD SET ACTOR_NAME=? , MOVIE_LIST=? WHERE ACTOR_ID=?";
	private static final String DELETE_ACTOR_BY_ID = "DELETE FROM ACTORS_RECORD WHERE ACTOR_ID =?";
	private static final String GET_ACTOR_BY_NAME = "SELECT * FROM ACTORS_RECORD WHERE ACTOR_NAME=?";
   
	//Connection reference
     private Connection connection;
     
	//Get Connection object using DataSource as a parameter of actorsDao class constructor
	 public ActorsDao(DataSource dataSource) throws Exception
	 {
		 this.connection = dataSource.getConnection();
	 }
	  
	
	 // Retrieve all the actors records from database table
	
	@Override
	public List<Actor> getAllActors() {
         
		List<Actor> list = new ArrayList<>();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(RETRIEVE_ALL_ACTORS))
		{   
			    
		       while(resultSet.next())
		       {
		    	    Actor actor = Actor.builder().actorId(resultSet.getInt(1)).actorName(resultSet.getString(2)).movieName(resultSet.getString(3)).build();
		    	    //store in list collection
		    	    list.add(actor);
		       }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	// Get specific actor record by there id
	@Override
	public Actor getActorById(int id) 
	{
		Actor  actor = null;
        try (PreparedStatement prepareStatement = connection.prepareStatement(GET_ACTOR_BY_ID)) {
			
        	prepareStatement.setInt(1, id);
        	
           ResultSet resultSet = prepareStatement.executeQuery();
           
           if(resultSet.next())
           {
        	     actor = Actor.builder().actorId(resultSet.getInt(1)).actorName(resultSet.getString(2)).movieName(resultSet.getString(3)).build();
           }
        	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;
	}

	// add new record in database table
	@Override
	public void addActor(Actor actor)
	{
            try (PreparedStatement prepareStatement = connection.prepareStatement(ADD_ACTOR_RECORD)) 
            {
				   prepareStatement.setInt(1, actor.getActorId());
				   prepareStatement.setString(2, actor.getActorName());
				   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// Update existing record to new record
	@Override
	public void updateActor(Actor actor) {

	}

	// Delete actor record based on there id
	@Override
	public void deleteActor(int id) {

	}

	// Get actor record based on the actors name
	@Override
	public Actor getActor(String actorName) {

		return null;
	}

}
