package com.example.demo.commands;

import java.util.List;
import com.example.demo.config.MusicPlayer;
import com.example.demo.entities.Playlist;

public class DeletePlaylistCommand implements ICommand{
    
    private final MusicPlayer musicPlayer; 

    public DeletePlaylistCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);

        boolean result = MusicPlayer.getInstance().deletePlaylist(playlistName);

        if (result) {
            System.out.println("Playlist " + playlistName + " is deleted!");
        } else {
            System.out.println("Failed to delete playlist.");
        }
    }
}
