package Timer.TimerPresenters;

import Timer.TimerOutputBoundaries.TimerOutputBoundary;
import Timer.TimerUseCases.TimerResponseModel;

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
