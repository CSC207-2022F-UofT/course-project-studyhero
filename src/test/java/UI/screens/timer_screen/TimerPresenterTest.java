package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerResponseModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerPresenterTest {

    @Test
    void getOutputTime() {
        TimerResponseModel timerResponseModel = new TimerResponseModel();
        TimerPresenter timerPresenter = new TimerPresenter(timerResponseModel);
        timerResponseModel.setOutputTime("55:55:55");
        assertEquals("55:55:55", timerPresenter.getOutputTime());
    }
}