package com.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.Player;
@Component
public class PlayerTestRunner implements CommandLineRunner
{
	@Autowired
    private Player   player;
	@Override
	public void run(String... args) throws Exception
	{
		
		System.out.println(player);
		
	}

}
