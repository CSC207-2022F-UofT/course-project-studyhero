package use_cases.music_controls;

import entities.MusicPlayer;

public class PlayMusic implements PlayMusicInputBoundary{
    private final MusicPlayer player;

    public PlayMusic(MusicPlayer player){
        this.player = player;
    }

    @Override
    public void playMusic(){
        this.player.getClip().start();
        this.player.setStatus("play");
    }
}
