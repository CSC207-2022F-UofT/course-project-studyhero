package settings;
import settings.music.entities.MusicPlayer;
import org.junit.jupiter.api.*;
import errors.usecases.ErrorOutputBoundary;
import errors.usecases.ErrorPresenter;
import settings.music.usecases.PauseMusic;
import settings.music.usecases.PlayMusic;

public class MusicControlTest {
    private final ErrorOutputBoundary presenter = new ErrorPresenter();
    private MusicPlayer player;

    public void checkPlaying(MusicPlayer player) {
        long t1 = player.getClip().getMicrosecondPosition();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long t2 = player.getClip().getMicrosecondPosition();
        Assertions.assertEquals("play", player.getStatus());
        Assertions.assertNotEquals(t1, t2);
    }

    public void checkPaused(MusicPlayer player) {
        long t1 = player.getClip().getMicrosecondPosition();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long t2 = player.getClip().getMicrosecondPosition();
        Assertions.assertEquals("paused", player.getStatus());
        Assertions.assertEquals(t1, t2);
    }


    @BeforeEach
    public void setUp(){
        player = new MusicPlayer("btd1.wav", presenter);
        // assert initially playing
        checkPlaying(player);
    }

    @Test
    public void PauseMusicWhenPlayingOrPaused(){
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
    public void PlayMusicWhenPlayingOrPaused() {
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

}
