package Timer.timer_screen;

import Timer.timer_use_cases.TimerOutputBoundary;
import Timer.timer_use_cases.TimerResponseModel;

public class TimerPresenter implements TimerOutputBoundary {
    final TimerResponseModel tResponseModel;
    String outputTime;

    public TimerPresenter(TimerResponseModel tResponseModel) {
        this.tResponseModel = tResponseModel;
    }

    @Override
    public String updateTimer() {
        this.outputTime = tResponseModel.getOutputTime();
        return outputTime;
    }
}
