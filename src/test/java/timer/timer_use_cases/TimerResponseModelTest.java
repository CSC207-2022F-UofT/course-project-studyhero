package timer.timer_use_cases;

import Timer.timer_use_cases.TimerResponseModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerResponseModelTest {

    @Test
    void getOutputTime() {
        TimerResponseModel timerResponseModel = new TimerResponseModel();
        timerResponseModel.setOutputTime("00:10:00");
        assertEquals("00:10:00", timerResponseModel.getOutputTime());
    }

    @Test
    void setOutputTime() {
        TimerResponseModel timerResponseModel = new TimerResponseModel();
        timerResponseModel.setOutputTime("00:10:00");
        assertEquals("00:10:00", timerResponseModel.getOutputTime());
    }

    @Test
    void getElapsedTime() {
        TimerResponseModel timerResponseModel = new TimerResponseModel();
        timerResponseModel.setElapsedTime(100);
        assertEquals(100, timerResponseModel.getElapsedTime());
    }

    @Test
    void setElapsedTime() {
        TimerResponseModel timerResponseModel = new TimerResponseModel();
        timerResponseModel.setElapsedTime(100);
        assertEquals(100, timerResponseModel.getElapsedTime());
    }
}