package use_cases.music;

import entities.MusicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayController implements ActionListener {
    MusicPlayer player;
    public PlayController(MusicPlayer player){
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.play();
    }
}
