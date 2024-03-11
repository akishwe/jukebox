package com.example.demo.commands;

import java.util.List;
import com.example.demo.config.MusicPlayer;

public class PlaySongCommand implements ICommand{
    
    private final MusicPlayer musicPlayer; 

    public PlaySongCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void invoke(List<String> tokens) {
        MusicPlayer.getInstance().playSong();
    }
}
