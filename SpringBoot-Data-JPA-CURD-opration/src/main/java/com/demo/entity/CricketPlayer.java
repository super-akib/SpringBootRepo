package com.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Criket_player_info")
public class CricketPlayer
{
	 @Id
	 @Column(name="Player_id")
     private Long playerId;
	 
	 
	 @Column(name="player_name" , length = 80)
	 private String playerName;
	 
	
	 @Column(name="Age")
     private Integer playerAge;
	 
	 
	 @Column(name="team_name" ,length = 80)
     private String teamName;
	 
	 @Column(name ="player_role")
     private List<RoleInfo> role;
}
