package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerOutputBoundary;
import Timer.timer_use_cases.TimerResponseModel;

public class TimerPresenter implements TimerOutputBoundary {
    final TimerResponseModel timerResponseModel;
    String outputTime;

    public TimerPresenter(TimerResponseModel timerResponseModel) {
        this.timerResponseModel = timerResponseModel;
    }

    @Override
    public String getOutputTime() {
        this.outputTime = timerResponseModel.getOutputTime();
        return outputTime;
    }
}
