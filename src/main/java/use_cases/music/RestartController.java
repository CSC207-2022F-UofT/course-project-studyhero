package use_cases.music;

import entities.MusicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartController implements ActionListener {
    MusicPlayer player;
    public RestartController(MusicPlayer player){
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.restart();
    }
}
