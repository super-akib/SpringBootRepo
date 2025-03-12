package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.Team;

@Repository("teamDao")
public class TeamDao {
    @Autowired
    private DataSource dataSource;

    public void saveTeamInfo(Team teaminfo) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO TEAM_PROFILE VALUES(?,?,?,?)")) {
             
            prepareStatement.setInt(1, teaminfo.getTeamId());
            prepareStatement.setString(2, teaminfo.getTeamName());
            prepareStatement.setString(3, teaminfo.getTeamCoach());
            prepareStatement.setInt(4, teaminfo.getFoundedYear());
            
            int i = prepareStatement.executeUpdate();
            
            if (i <= 0) {
                throw new IllegalArgumentException("Data cannot be stored in database table, please try again");
            } else {
                System.out.println("Data successfully stored in database table");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
