package com.example.demo.commands;

import java.util.List;
import com.example.demo.config.MusicPlayer;

public class PreviousSongCommand implements ICommand{
    
    private final MusicPlayer musicPlayer; 

    public PreviousSongCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void invoke(List<String> tokens) {
        MusicPlayer.getInstance().previousSong();
    }
}
