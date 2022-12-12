package timer.timer_use_cases;

import Timer.timer_use_cases.TimerInteractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerInteractorTest {

    @Test
    void startTimer() {
        TimerInteractor timerInteractor = new TimerInteractor();
        timerInteractor.setTimer("00:45:00");
        timerInteractor.startTimer();
        assertTrue(timerInteractor.timerEntity.isRunning);
    }

    @Test
    void setTimer() {
        TimerInteractor timerInteractor = new TimerInteractor();
        timerInteractor.setTimer("00:15:00");
        assertEquals("00:15:00", timerInteractor.time);
    }
}