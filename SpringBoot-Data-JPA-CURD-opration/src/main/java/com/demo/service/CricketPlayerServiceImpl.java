package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.CricketPlayer;
import com.demo.entity.RoleInfo;
import com.demo.repository.CricketPlayerRepository;

@Service("cricketPlayerService")
public class CricketPlayerServiceImpl implements ICricketPlayerService 
{

	//Get the Repository object reference
	@Autowired
	private CricketPlayerRepository  cricketPlayerRepository;
	
	
	// Save operation
	@Override
	public CricketPlayer saveCricketPlayerInfo(CricketPlayer criketPlayer)
	{
		//inject the entity class object in pre-define save method
		//it will return saved object
		return cricketPlayerRepository.save(criketPlayer);
	}
    
	//Read operation
	@Override
	public List<CricketPlayer> fetchCricketPlayersList()
	{
		//here it will return Iterable explicit type cast to list   
		return  (List<CricketPlayer>) cricketPlayerRepository.findAll();
	}

	// Update operation
	@Override
	public CricketPlayer updateCrickertPlayer(CricketPlayer criketPlayer, Long playerId)
	{
		Optional<CricketPlayer> optionalPlayer = cricketPlayerRepository.findById(playerId);
		
		if(optionalPlayer.isPresent())
		{
			CricketPlayer existingPlayer = optionalPlayer.get();
		    //Set existing object properties to new object properties
			existingPlayer.setPlayerName(criketPlayer.getPlayerName());
		    existingPlayer.setTeamName(criketPlayer.getTeamName());
		    existingPlayer.setRole(criketPlayer.getRole());
			
		    //pass existing object in save method
		    cricketPlayerRepository.save(existingPlayer);
		}
		else
		{
			throw new IllegalArgumentException("Invalid Player Id try again");
		}
		return criketPlayer;
	}

	//Delete operation
	@Override
	public void deletePlayerById(Long playerId) 
	{
	    cricketPlayerRepository.deleteById(playerId);
	}

	//Record find by Id
	@Override
	public CricketPlayer playerFindById(Long playerId) {
	
		Optional<CricketPlayer> findById = cricketPlayerRepository.findById(playerId);
		
		if(findById.isEmpty())
		{
			throw new IllegalArgumentException("Invalid Player Id try again");
		}
		CricketPlayer cricketPlayer = findById.get();
			
		return cricketPlayer;
	}

	@Override
	public Iterable<CricketPlayer> getAll() {
		
		return cricketPlayerRepository.findAll();
	}

}
