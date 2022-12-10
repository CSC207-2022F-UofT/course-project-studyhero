package use_cases;
import entities.MusicPlayer;
import org.junit.jupiter.api.*;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.music_controls.PauseMusic;
import use_cases.music_controls.PlayMusic;
import use_cases.music_controls.RestartMusic;

import java.util.concurrent.TimeUnit;

public class MusicControlTest {
    private final ErrorOutputBoundary presenter = new ErrorPresenter();
    private MusicPlayer player;

    public void checkPlaying(MusicPlayer player) throws InterruptedException {
        long t1 = player.getClip().getMicrosecondPosition();
        TimeUnit.SECONDS.sleep(1);
        long t2 = player.getClip().getMicrosecondPosition();
        Assertions.assertEquals("play", player.getStatus());
        Assertions.assertNotEquals(t1, t2);
    }

    public void checkPaused(MusicPlayer player) throws InterruptedException {
        long t1 = player.getClip().getMicrosecondPosition();
        TimeUnit.SECONDS.sleep(1);
        long t2 = player.getClip().getMicrosecondPosition();
        Assertions.assertEquals("paused", player.getStatus());
        Assertions.assertEquals(t1, t2);
    }


    @BeforeEach
    public void setUp() throws InterruptedException {
        player = new MusicPlayer("btd1.wav", presenter);
        // assert initially playing
        checkPlaying(player);
    }

    @Test
    public void PauseMusicWhenPlayingOrPaused() throws InterruptedException {
        // assert pause when playing
        PauseMusic pauseMusic = new PauseMusic(player);
        pauseMusic.pauseMusic();

        checkPaused(player);
        long t1 = player.getClip().getMicrosecondPosition();

        // assert pause when paused does nothing
        pauseMusic.pauseMusic();
        checkPaused(player);
        long t2 = player.getClip().getMicrosecondPosition();
        Assertions.assertEquals(t1, t2);
    }

    @Test
    public void PlayMusicWhenPlayingOrPaused() throws InterruptedException {
        // assert play when already playing does nothing
        PlayMusic playMusic = new PlayMusic(player);
        playMusic.playMusic();
        checkPlaying(player);

        PauseMusic pauseMusic = new PauseMusic(player);
        long t3 = player.getClip().getMicrosecondPosition();
        pauseMusic.pauseMusic();
        checkPaused(player);

        // assert play from paused status changes status to play and
        // plays from position at pause (less than a microsecond apart)
        playMusic.playMusic();
        long t6 = player.getClip().getMicrosecondPosition();
        checkPlaying(player);
        Assertions.assertTrue(((t6-t3)/1000000) < 1);

    }

    @Test
    public void RestartMusicWhenPlayingOrPaused() throws InterruptedException {
        RestartMusic restartMusic = new RestartMusic(player);
        // assert restarting when playing moves position to 0
        long t1 = player.getClip().getMicrosecondPosition();
        restartMusic.restartMusic();
        long t2 = player.getClip().getMicrosecondPosition();
        Assertions.assertNotEquals(t1, t2);
        Assertions.assertTrue(t2 < 10000);
        checkPlaying(player);

        // pause from restart
        PauseMusic pauseMusic = new PauseMusic(player);
        pauseMusic.pauseMusic();
        checkPaused(player);

        long t3 = player.getClip().getMicrosecondPosition();
        restartMusic.restartMusic();
        long t4 = player.getClip().getMicrosecondPosition();
        Assertions.assertNotEquals(t3,t4);
        Assertions.assertTrue(t4 < 10000);
        checkPlaying(player);


    }

}
