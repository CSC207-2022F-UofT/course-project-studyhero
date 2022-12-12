package use_cases.music_controls;

import entities.MusicPlayer;

/**
 *  A use case responsible for pausing music.
 */
public class PauseMusic implements PauseMusicInputBoundary{
    private final MusicPlayer player;

    /**
     * Creates a PauseMusic object that manipulates a MusicPlayer object
     *
     * @param player a MusicPlayer object that can play, pause and restart music
     */
    public PauseMusic(MusicPlayer player){
        this.player = player;
    }

    /**
     * Pauses music if the MusicPlayer is not already paused and stores
     * the current position of the clip into the MusicPlayer. If it is
     * already paused, nothing will happen.
     */
    @Override
    public void pauseMusic(){
        if (!player.getStatus().equals("paused")){
            //player.setCurrentPos(player.getClip().getMicrosecondPosition());
            player.getClip().stop();
            player.setStatus("paused");
        }
    }
}
