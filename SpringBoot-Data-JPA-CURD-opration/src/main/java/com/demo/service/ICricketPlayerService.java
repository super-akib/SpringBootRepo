package com.demo.service;

import java.util.List;

import com.demo.entity.CricketPlayer;

public interface ICricketPlayerService
{
	// Save operation
    CricketPlayer saveCricketPlayerInfo(CricketPlayer criketPlayer);
 
    // Read operation
    List<CricketPlayer> fetchCricketPlayersList();
 
    // Update operation
    CricketPlayer updateCrickertPlayer(CricketPlayer criketPlayer,
                                Long playerId);
 
    // Delete operation
    void deletePlayerById(Long playerId);
    
    //Find by Id
    CricketPlayer  playerFindById(Long playerId);
    public Iterable<CricketPlayer> getAll();
}
