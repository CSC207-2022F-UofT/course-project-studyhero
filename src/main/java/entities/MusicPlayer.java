package entities;

import use_cases.errors.ErrorOutputBoundary;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private Long currentPos;
    private Clip clip;
    String status;
    AudioInputStream inputStream;
    String filepath;
    ErrorOutputBoundary presenter;

    public MusicPlayer(String filepath, ErrorOutputBoundary presenter){
        this.presenter = presenter;

        try {
            this.filepath = filepath;
            this.inputStream = AudioSystem.getAudioInputStream(new File(filepath));
            this.clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            this.play();
            this.status = "play";

        } catch (UnsupportedAudioFileException | LineUnavailableException
                 | IOException e) {
            presenter.error(e.getMessage());
        }
    }

    public String getStatus(){return status;}
    public void setStatus(String newStatus){status = newStatus;}
    public Long getCurrentPos(){return currentPos;}
    public void setCurrentPos(Long Pos){currentPos = Pos;}
    public Clip getClip(){return clip;}


    public void play(){
        clip.start();
        status = "play";
    }

    public void resetAudioStream()
    {
        try {
            inputStream = AudioSystem.getAudioInputStream(
                    new File(filepath).getAbsoluteFile());
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException
                 | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

}
