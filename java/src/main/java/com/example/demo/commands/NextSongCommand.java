package com.example.demo.commands;

import java.util.List;
import com.example.demo.config.MusicPlayer;

public class NextSongCommand implements ICommand{
    
    private final MusicPlayer musicPlayer; 

    public NextSongCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void invoke(List<String> tokens) {
        MusicPlayer.getInstance().nextSong();
    }
}
