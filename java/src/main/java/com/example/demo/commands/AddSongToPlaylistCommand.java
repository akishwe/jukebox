package com.example.demo.commands;

import java.util.List;
import com.example.demo.config.MusicPlayer;
import com.example.demo.entities.Song;

public class AddSongToPlaylistCommand implements ICommand{
    
    private final MusicPlayer musicPlayer; 

    public AddSongToPlaylistCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        String songId = tokens.get(2);

        boolean result = MusicPlayer.getInstance().addSongToPlaylist(playlistName, songId);

        if (result) {
            System.out.println("Playlist " + playlistName + " is revised with " +
                    MusicPlayer.getInstance().getPlaylist(playlistName).getSongs());
        } else {
            System.out.println("Failed to add song to playlist.");
        }
    }
}
