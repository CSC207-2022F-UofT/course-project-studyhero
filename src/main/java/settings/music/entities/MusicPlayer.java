package settings.music.entities;

import errors.usecases.ErrorOutputBoundary;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private Clip clip;
    private String status;
    private AudioInputStream inputStream;
    private String filepath;

    /**
     * Creates a MusicPlayer object that plays music of wav file with
     * filepath name, and presents an error if the file is invalid.
     *
     * @param filepath filepath of .wav file
     * @param presenter output boundary if error occurs
     */
    public MusicPlayer(String filepath, ErrorOutputBoundary presenter){

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
    public Clip getClip(){return clip;}

    /**
     *  Starts playing the music of the filepath.
     */

    public void play(){
        clip.start();
        status = "play";
    }

    /**
     * Resets the music to the beginning of the file.
     */
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
