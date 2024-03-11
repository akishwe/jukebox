package com.example.demo.commands;

import java.util.List;
import com.example.demo.config.MusicPlayer;
import com.example.demo.entities.Song;

public class ListSongsCommand implements ICommand{
    
    private final MusicPlayer musicPlayer; 

    public ListSongsCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Song> songs = MusicPlayer.getInstance().getAllSongs();
        System.out.println(songs);
    }

}
