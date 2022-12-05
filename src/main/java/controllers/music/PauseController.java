package controllers.music;

import entities.MusicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseController implements ActionListener {
    MusicPlayer player;
    public PauseController(MusicPlayer player){
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.pause();
    }
}
