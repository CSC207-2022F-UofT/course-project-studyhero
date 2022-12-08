package entities;

import use_cases.errors.ErrorPresenter;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    Long currentPos;
    Clip clip;
    String status;
    AudioInputStream inputStream;
    String filepath;
    ErrorPresenter presenter;

    public MusicPlayer(String filepath){
        this.presenter = new ErrorPresenter();
        try {
            this.filepath = filepath;
            this.inputStream = AudioSystem.getAudioInputStream(new File(filepath));
            this.clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | LineUnavailableException
                 | IOException e) {
            presenter.error(e.getMessage());
        }
    }

    public void play(){
        clip.start();
        status = "play";
    }
    public void pause(){
        if (!status.equals("paused")){
            this.currentPos = this.clip.getMicrosecondPosition();
            clip.stop();
            status = "paused";
        }
    }

    public void restart(){
        clip.stop();
        clip.close();
        resetAudioStream();
        currentPos = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
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
