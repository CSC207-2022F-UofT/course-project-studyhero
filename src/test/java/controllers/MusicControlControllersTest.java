package controllers;

import controllers.music.PauseController;
import controllers.music.PlayController;
import controllers.music.RestartController;
import entities.MusicPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.music_controls.*;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class MusicControlControllersTest {
    ErrorOutputBoundary presenter = new ErrorPresenter();
    MusicPlayer player = new MusicPlayer("btd1.wav", presenter);
    PlayMusicInputBoundary playMusic = new PlayMusic(player);
    PauseMusicInputBoundary pauseMusic = new PauseMusic(player);
    RestartMusicInputBoundary restartMusic = new RestartMusic(player);
    PlayController playController = new PlayController(playMusic);
    PauseController pauseController = new PauseController(pauseMusic);
    RestartController restartController = new RestartController(restartMusic);


    @Test
    public void TestPlayWhenPlaying(){
        ActionEvent e1 = new ActionEvent(new Object(), 1, "play");
        playController.actionPerformed(e1);
        Assertions.assertEquals(player.getStatus(), "play");

        ActionEvent e2 = new ActionEvent(new Object(), 2, "play");
        playController.actionPerformed(e2);
        Assertions.assertEquals(player.getStatus(), "play");
    }

    @Test
    public void TestPlayWhenPaused(){
        ActionEvent e1 = new ActionEvent(new Object(), 1, "play");
        pauseController.actionPerformed(e1);
        Assertions.assertEquals(player.getStatus(), "paused");

        ActionEvent e2 = new ActionEvent(new Object(), 2, "play");
        playController.actionPerformed(e2);
        Assertions.assertEquals(player.getStatus(), "play");
    }

    @Test
    public void TestPause(){
        String oldStatus = player.getStatus();
        ActionEvent e1 = new ActionEvent(new Object(), 1, "play");
        pauseController.actionPerformed(e1);
        if (Objects.equals(oldStatus, "play")){
            Assertions.assertNotEquals(player.getStatus(), oldStatus);
            Assertions.assertEquals(player.getStatus(), "paused");}
        if (Objects.equals(oldStatus, "pause")){
            Assertions.assertEquals(player.getStatus(), oldStatus);}
    }

    @Test
    public void TestRestartWhenPlaying(){
        ActionEvent e1 = new ActionEvent(new Object(), 1, "play");
        playController.actionPerformed(e1);
        Assertions.assertEquals(player.getStatus(), "play");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long t1 = player.getClip().getMicrosecondPosition();
        Assertions.assertTrue(t1 > 100000);

        ActionEvent e2 = new ActionEvent(new Object(), 2, "play");
        restartController.actionPerformed(e2);
        Assertions.assertEquals(player.getStatus(), "play");
        long t2 = player.getClip().getMicrosecondPosition();

        Assertions.assertNotEquals(t1, t2);
        Assertions.assertTrue(t2 < 10000);
    }

    @Test
    public void TestRestartWhenPaused(){
        ActionEvent e1 = new ActionEvent(new Object(), 1, "pause");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pauseController.actionPerformed(e1);
        Assertions.assertEquals(player.getStatus(), "paused");
        long t1 = player.getClip().getMicrosecondPosition();
        Assertions.assertTrue(t1 > 100000);

        ActionEvent e2 = new ActionEvent(new Object(), 2, "play");
        restartController.actionPerformed(e2);
        Assertions.assertEquals(player.getStatus(), "play");
        long t2 = player.getClip().getMicrosecondPosition();

        Assertions.assertNotEquals(t1, t2);
        Assertions.assertTrue(t2 < 10000);
    }

}
