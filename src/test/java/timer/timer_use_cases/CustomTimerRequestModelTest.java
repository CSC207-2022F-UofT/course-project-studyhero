package timer.timer_use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomTimerRequestModelTest {

    @Test
    void getCustomTime() {
        CustomTimerRequestModel customTimerRequestModel = new CustomTimerRequestModel();
        customTimerRequestModel.setCustomTime("00:10:00");
        assertEquals("00:10:00", customTimerRequestModel.getCustomTime());
    }

    @Test
    void setCustomTime() {
        CustomTimerRequestModel customTimerRequestModel = new CustomTimerRequestModel();
        customTimerRequestModel.setCustomTime("00:10:00");
        assertEquals("00:10:00", customTimerRequestModel.getCustomTime());
    }
}