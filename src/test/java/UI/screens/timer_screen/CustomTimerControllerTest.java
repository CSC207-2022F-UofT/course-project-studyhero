package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerInteractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomTimerControllerTest {

    @Test
    void startTimer() {
        TimerInteractor timerInteractor = new TimerInteractor();
        CustomTimerController customTimerController = new CustomTimerController(timerInteractor);
        customTimerController.setCustomTime("00:20:00");
        customTimerController.startTimer();
        assertTrue(timerInteractor.timerEntity.isRunning);
    }

    @Test
    void setCustomTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        CustomTimerController customTimerController = new CustomTimerController(timerInteractor);
        customTimerController.setCustomTime("00:20:00");
        assertEquals("00:20:00", customTimerController.customTimerRequestModel.getCustomTime());
    }

    @Test
    void getCustomTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        CustomTimerController customTimerController = new CustomTimerController(timerInteractor);
        customTimerController.setCustomTime("00:20:00");
        assertEquals("00:20:00", customTimerController.getCustomTime());
    }
}