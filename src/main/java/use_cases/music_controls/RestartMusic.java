package use_cases.music_controls;

import entities.MusicPlayer;

/**
 * A use case that is responsible for restarting music.
 */
public class RestartMusic implements RestartMusicInputBoundary{
    MusicPlayer player;

    /**
     * Creates a RestartMusic object that manipulates a MusicPlayer object.
     *
     * @param player a MusicPlayer object that can play, pause and restart music
     */
    public RestartMusic(MusicPlayer player){
        this.player = player;
    }

    /**
     * Restarts the music of the MusicPlayer. Regardless of whether the
     * music is currently paused or playing, the music will restart and
     * begin playing.
     */
    @Override
    public void restartMusic(){
        this.player.getClip().stop();
        this.player.getClip().close();
        this.player.resetAudioStream();
        this.player.getClip().setMicrosecondPosition(0);
        this.player.play();
    }
}
