package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.TeamDao;
import com.demo.model.Team;

import lombok.Setter;


@Service("teamService")
@Setter
public class TeamService {
    @Autowired
    private TeamDao teamDao;
    
    @Autowired
    private Team teamInfo;

    public void storeTeamData() throws Exception {
        teamDao.saveTeamInfo(teamInfo);
    }
}
