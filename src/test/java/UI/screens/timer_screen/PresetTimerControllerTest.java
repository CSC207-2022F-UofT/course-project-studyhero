package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerInteractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresetTimerControllerTest {

    @Test
    void startTimer() {
        TimerInteractor timerInteractor = new TimerInteractor();
        PresetTimerController presetTimerController = new PresetTimerController(timerInteractor);
        presetTimerController.selectShortTime();
        presetTimerController.startTimer();
        assertTrue(timerInteractor.timerEntity.isRunning);
    }

    @Test
    void selectShortTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        PresetTimerController presetTimerController = new PresetTimerController(timerInteractor);
        presetTimerController.selectShortTime();
        assertEquals("00:15:00", presetTimerController.presetTimerRequestModel.getSelectedTime());
    }

    @Test
    void selectMediumTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        PresetTimerController presetTimerController = new PresetTimerController(timerInteractor);
        presetTimerController.selectMediumTime();
        assertEquals("00:30:00", presetTimerController.presetTimerRequestModel.getSelectedTime());
    }

    @Test
    void selectLongTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        PresetTimerController presetTimerController = new PresetTimerController(timerInteractor);
        presetTimerController.selectLongTime();
        assertEquals("01:00:00", presetTimerController.presetTimerRequestModel.getSelectedTime());
    }

    @Test
    void getShortTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        PresetTimerController presetTimerController = new PresetTimerController(timerInteractor);
        assertEquals("00:15:00", presetTimerController.getShortTime());
    }

    @Test
    void getMediumTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        PresetTimerController presetTimerController = new PresetTimerController(timerInteractor);
        assertEquals("00:30:00", presetTimerController.getMediumTime());
    }

    @Test
    void getLongTime() {
        TimerInteractor timerInteractor = new TimerInteractor();
        PresetTimerController presetTimerController = new PresetTimerController(timerInteractor);
        assertEquals("01:00:00", presetTimerController.getLongTime());
    }
}