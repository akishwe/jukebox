package com.example.demo;

import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.config.MusicPlayer;
import com.example.demo.config.PlaylistManager;
import com.example.demo.config.SongManager;
import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongsCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.services.GreetingService;


public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();
            private MusicPlayer musicPlayer;
            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private final DeletePlaylistCommand  deletePlaylistCommand = new DeletePlaylistCommand(musicPlayer);
            private final AddSongCommand  addSongCommand = new AddSongCommand(musicPlayer);
            private final ListSongsCommand  listSongCommand = new ListSongsCommand(musicPlayer);
            private final CreatePlaylistCommand  createPlaylistCommand = new CreatePlaylistCommand(musicPlayer);
            private final LoadPlaylistCommand  loadPlaylistCommand = new LoadPlaylistCommand(musicPlayer);
            private final PlaySongCommand  playSongCommand = new PlaySongCommand(musicPlayer);
            private final NextSongCommand  nextSongCommand = new NextSongCommand(musicPlayer);
            private final PreviousSongCommand  previousSongCommand = new PreviousSongCommand(musicPlayer);
            private final StopSongCommand  stopSongCommand = new StopSongCommand(musicPlayer);
            private final AddSongToPlaylistCommand  addSongToPlaylistCommand = new AddSongToPlaylistCommand(musicPlayer);
            private final DeleteSongFromPlaylistCommand  deleteSongFromPlaylistCommand = new DeleteSongFromPlaylistCommand(musicPlayer);
            

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG.getName(),addSongCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONGS.getName(),listSongCommand);
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST.getName(),createPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST.getName(),deletePlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST.getName(),loadPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG.getName(),playSongCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG.getName(),nextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG.getName(),previousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG.getName(),stopSongCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST.getName(),addSongToPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST.getName(),deleteSongFromPlaylistCommand);
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
