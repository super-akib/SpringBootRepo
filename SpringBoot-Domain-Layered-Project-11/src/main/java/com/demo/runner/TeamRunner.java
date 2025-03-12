package com.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.service.TeamService;

@Component
public class TeamRunner implements CommandLineRunner {
    @Autowired 
    private TeamService teamService;
    
    @Override
    public void run(String... args) throws Exception {
        teamService.storeTeamData();
    }
}
