package UI.screens.panels;

import use_cases.errors.ErrorPresenter;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MusicScreen {
    Long currentPos;
    Clip clip;
    String status;
    AudioInputStream inputStream;
    String filepath;
    ErrorPresenter presenter;

    public MusicScreen(String filepath){
        this.presenter = new ErrorPresenter();
        try {
            this.filepath = filepath;
            this.inputStream = AudioSystem.getAudioInputStream(new File(filepath));
            this.clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException e) {
            presenter.error(e.getMessage());
        } catch (IOException e)  {
            presenter.error(e.getMessage());
        } catch (LineUnavailableException e) {
            presenter.error(e.getMessage());
        }

    }

    public void play(){
        clip.start();
        status = "play";
    }
    public void pause(){
        if (status.equals("paused")){
            presenter.error("Music is already paused.");
        }
        else{
            this.currentPos = this.clip.getMicrosecondPosition();
            clip.stop();
            status = "paused";
        }
    }
    public void stop(){
        currentPos = 0L;
        clip.stop();
        clip.close();
    }

    public static void main(String[] args){
        JFrame musicPlayer = new JFrame("Music");
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Music Player here");
        JButton pause = new JButton("Pause");
        JButton stop = new JButton("Stop");
        JButton play = new JButton("Play");
        try{
            MusicScreen player = new MusicScreen("bgm.wav");
            player.play();
            pause.addActionListener(e -> player.pause());
            stop.addActionListener(e -> player.stop());
            play.addActionListener(e-> player.play());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        panel.add(title);
        panel.add(pause);
        panel.add(stop);
        panel.add(play);
        musicPlayer.add(panel);
        musicPlayer.pack();
        musicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        musicPlayer.setVisible(true);


    }


}
