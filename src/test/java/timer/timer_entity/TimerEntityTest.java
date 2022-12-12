package timer.timer_entity;

import Timer.timer_entity.TimerEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerEntityTest {

    @Test
    void startTimer() {
        TimerEntity timerEntity = new TimerEntity();
        int[] time = new int[]{10, 20, 10};
        timerEntity.setTimer(time);
        timerEntity.startTimer();
        assertTrue(timerEntity.isRunning);
    }

    @Test
    void setTimer() {
        TimerEntity timerEntity = new TimerEntity();
        int[] time = new int[]{10, 20, 10};
        timerEntity.setTimer(time);
        assertEquals(timerEntity.startingTime, time);
    }

    @Test
    void endTimer() {
        TimerEntity timerEntity = new TimerEntity();
        int[] time = new int[]{10, 20, 10};
        timerEntity.setTimer(time);
        timerEntity.startTimer();
        timerEntity.endTimer();
        assertFalse(timerEntity.isRunning);
    }

    @Test
    void updateTime() {
        TimerEntity timerEntity = new TimerEntity();
        int[] time = new int[]{10, 20, 10};
        timerEntity.setTimer(time);
        assertEquals(timerEntity.startingTime, time);
    }

    @Test
    void getElapsedTime() {
        TimerEntity timerEntity = new TimerEntity();
        timerEntity.elapsedTime = 100;
        assertEquals(100, timerEntity.getElapsedTime());
    }
}