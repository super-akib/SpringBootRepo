package com.nit.sbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.dao.UserPlayListDao;
@Component("basicPlayList")
public class BasicPlaylist implements IPlaylist {

 
 @Autowired
 private UserPlayListDao userDao;
	@Override
	public void createPlaylist(User user, String playlistName)
	{
		
		int userData = userDao.insertUserData(user,playlistName);
		if(userData>0)
		{
			System.out.println("User Playlist Created sucessfully..");
		}
		else
		{
			throw new IllegalArgumentException("User playlist Not created please try again");
		}
	}

	@Override
	public void addSongToPlaylist(String playlistName, Song song) {
		
		 if(playlistName != null && song != null)
		 {
			 int addSongs = userDao.addSongs(playlistName, song);
			 
			 if(addSongs>0)
			 {
				 System.out.println("New Songs added sucessfully in Playlist");
			 }
			 else
			 {
				 throw new IllegalArgumentException("Song not be added in playList try again.");
			 }
		 }
	}

	@Override
	public void removeSongFromPlaylist(String playlistName, Song song) 
	{
		   int deleteSong = userDao.deleteSong(song);
         if(deleteSong>0)
         {
        	 System.out.println("Song deleted from playlist");
         }
	}

}
