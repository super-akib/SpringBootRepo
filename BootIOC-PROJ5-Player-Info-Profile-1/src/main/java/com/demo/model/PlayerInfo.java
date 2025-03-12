package com.demo.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component()
@Data
@Profile({"dhoni","virat","rohit","shammi"})
public class PlayerInfo 
{
    @Value("${player.playerId}")
	private Long playerId;
	
	@Value("${player.playerName}")
	private String playerName;
	
	@Value("${player.jursyNumber}")
	private Long playerJursyNumber;

	@Value("${player.totalMatch}")
	private Long playerTotalMatch;
	
	@Value("${player.dateOfBirth}")
	private Date  playerDateOfBirth;
	
	@Value("${player.isAllRounder}")
	private Boolean isAllRounder;

}
