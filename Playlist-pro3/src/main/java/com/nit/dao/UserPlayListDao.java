package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.sbean.Song;
import com.nit.sbean.User;

@Repository("userDao")
public class UserPlayListDao {
    
    @Autowired
    private Connection con;

    public int insertUserData(User user, String playListName) {
        int k = 0;

        try (PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO USER_LIST (USER_ID, USER_NAME, MAILID, PLAYLIST_NAME) VALUES (?, ?, ?, ?)")) {
            prepareStatement.setInt(1, user.getUserId());
            prepareStatement.setString(2, user.getUserName());
            prepareStatement.setString(3, user.getEmailId());
            prepareStatement.setString(4, playListName);

            k = prepareStatement.executeUpdate();

            // insert data into playList table
            if (k > 0) {
                PreparedStatement prepareStatement2 = con.prepareStatement("INSERT INTO PLAYLIST_OF_SONGS (PLAYLIST_NAME, SONG_ID, SONG_TITLE, ARTIST_NAME) VALUES (?, ?, ?, ?)");
                prepareStatement2.setString(1, playListName);
                prepareStatement2.setInt(2, user.getUserId());
                prepareStatement2.setString(3, user.getUserName());
                prepareStatement2.setString(4, user.getEmailId());

                prepareStatement2.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

    // Add songs in playlist_of_songs table
    public int addSongs(String playlistName, Song song) {
        int k = 0;
        try (PreparedStatement prepareStatement = con.prepareStatement("INSERT INTO PLAYLIST_OF_SONGS (PLAYLIST_NAME, SONG_ID, SONG_TITLE, ARTIST_NAME) VALUES (?, ?, ?, ?)")) {
            prepareStatement.setString(1, playlistName);
            prepareStatement.setInt(2, song.getSongId());
            prepareStatement.setString(3, song.getSongTitle());
            prepareStatement.setString(4, song.getArtistName());
            k = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

    // Delete song from table
    public int deleteSong(Song song) {
        int k = 0;

        try (PreparedStatement prepareStatement = con.prepareStatement("DELETE SONG_ID,SONG_TITLE,ARTIST_NAME FROM PLAYLIST_OF_SONGS WHERE SONG_ID = ?")) {
            prepareStatement.setInt(1, song.getSongId());
            k = prepareStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return k;
    }
}
