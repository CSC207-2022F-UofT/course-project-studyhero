package use_cases.music_controls;

import entities.MusicPlayer;

public class PauseMusic implements PauseMusicInputBoundary{
    private final MusicPlayer player;

    public PauseMusic(MusicPlayer player){
        this.player = player;
    }

    @Override
    public void pauseMusic(){
        if (!player.getStatus().equals("paused")){
            player.setCurrentPos(player.getClip().getMicrosecondPosition());
            player.getClip().stop();
            player.setStatus("paused");
        }
    }
}
