package com.nit;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nit.sbean.PlaylistManagementService;
import com.nit.sbean.Song;
import com.nit.sbean.User;


@SpringBootApplication
public class PlaylistPro3Application {
    
	@Bean(name="connection")
	public Connection getCon()
	{
		Connection con=null;
		try 
		{
		  	Class.forName("oracle.jdbc.driver.OracleDriver");
		  	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akib");
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(PlaylistPro3Application.class, args);
		
		PlaylistManagementService service = context.getBean(PlaylistManagementService.class);
		
		User user = User.builder().userId(101).userName("Mike").emailId("mike@Example.com").build();
		
		Song song = Song.builder().songId(1102).songTitle("Indian Army").artistName("Xyz").build();
		
		service.manageUserPlaylist(user, "add","MySong", song);
		
		
	}

}
