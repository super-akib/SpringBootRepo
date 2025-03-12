package com.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.CricketPlayer;
import com.demo.entity.RoleInfo;
import com.demo.service.CricketPlayerServiceImpl;
@Component
public class TestCurdOperationRunner implements CommandLineRunner
{
	@Autowired
    private CricketPlayerServiceImpl  service;

	@Override
	public void run(String... args) throws Exception
	{
	   //get Enum list from RoleInfo  
	   List<RoleInfo> list = List.of(RoleInfo.BATSMAN,RoleInfo.BOWLAR,RoleInfo.ALLROUNDER);
		
		
		
//		//create cricketPlayer class object using builder
//		CricketPlayer cricketplayer =  CricketPlayer.builder().playerId(1003l).playerName("Rohit").playerAge(36).teamName("Mumbai Indians").role(list).build();
//		
//		//invoke service save method
////		
//        System.out.println(cricketplayer);
//       CricketPlayer playerInfo = service.saveCricketPlayerInfo(cricketplayer);
//		System.out.println(playerInfo);
//		
//      	CricketPlayer playerFindById = service.playerFindById(1003l);
////     System.out.println("-----------------------------------\n");
//        System.out.println(playerFindById);
           service.getAll().forEach(System.out::println);
//		System.out.println("\n-----------------------------------");
	   
	   
   
	}

}
