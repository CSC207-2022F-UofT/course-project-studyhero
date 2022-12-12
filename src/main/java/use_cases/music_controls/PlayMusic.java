package use_cases.music_controls;

import entities.MusicPlayer;

/**
 * A use case responsible for playing music.
 */
public class PlayMusic implements PlayMusicInputBoundary{
    private final MusicPlayer player;

    /***
     * Creates a PlayMusic object that manipulates a MusicPlayer object.
     *
     * @param player a MusicPlayer object that can play, pause and restart music
     */
    public PlayMusic(MusicPlayer player){
        this.player = player;
    }

    /**
     * Plays music if the MusicPlayer is not already playing music
     * and starts at the most recent position of the clip. If it is
     * already playing, do nothing.
     */
    @Override
    public void playMusic(){
        this.player.getClip().start();
        this.player.setStatus("play");
    }
}
