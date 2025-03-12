package com.nit.sbean;

public interface IPlaylist {
	public void createPlaylist(User user, String playlistName);

	public void addSongToPlaylist(String playlistName, Song song);

	public void removeSongFromPlaylist(String playlistName, Song song);
	

}
