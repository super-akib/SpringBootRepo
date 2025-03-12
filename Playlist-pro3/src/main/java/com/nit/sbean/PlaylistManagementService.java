package com.nit.sbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistManagementService 
{   
	@Autowired
    private IPlaylist  playlist;
	
	public void manageUserPlaylist(User user, String action, String playlistName, Song song)
	{
		
		if(action.equalsIgnoreCase("create"))
		{  
			//create playList 
			playlist.createPlaylist(user, playlistName);
		}
		else if(action.equalsIgnoreCase("add"))
		{ 
			//add playList
			playlist.addSongToPlaylist(playlistName, song);
		}
		else if(action.equalsIgnoreCase("remove"))
		{
             //remove song from playList  
			playlist.removeSongFromPlaylist(playlistName, song);
		}
		else
		{
			throw new IllegalArgumentException("! O hoo , Please provide valid acton.....");
		}
					
	}
}
