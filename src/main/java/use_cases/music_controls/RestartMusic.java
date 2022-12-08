package use_cases.music_controls;

import entities.MusicPlayer;

public class RestartMusic implements RestartMusicInputBoundary{
    MusicPlayer player;

    public RestartMusic(MusicPlayer player){
        this.player = player;
    }

    @Override
    public void restartMusic(){
        this.player.getClip().stop();
        this.player.getClip().close();
        this.player.resetAudioStream();
        this.player.setCurrentPos(0L);
        this.player.getClip().setMicrosecondPosition(0);
        this.player.play();
    }
}
