package timer.timer_use_cases;

import Timer.timer_use_cases.PresetTimerRequestModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresetTimerRequestModelTest {

    @Test
    void getSelectedTime() {
        PresetTimerRequestModel presetTimerRequestModel = new PresetTimerRequestModel();
        presetTimerRequestModel.setSelectedTime("00:15:00");
        assertEquals("00:15:00", presetTimerRequestModel.getSelectedTime());
    }

    @Test
    void setSelectedTime() {
        PresetTimerRequestModel presetTimerRequestModel = new PresetTimerRequestModel();
        presetTimerRequestModel.setSelectedTime("00:15:00");
        assertEquals("00:15:00", presetTimerRequestModel.getSelectedTime());
    }
}