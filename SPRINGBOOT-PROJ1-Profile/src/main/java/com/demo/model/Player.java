package com.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("player")
@Data
@ConfigurationProperties(prefix = "player")
public class Player 
{
	
	private String gameName;
	
	private Long  playerId;
	
	private String playerName;
	
	private String playerPosition;
	
	private Integer playerAge;
}
