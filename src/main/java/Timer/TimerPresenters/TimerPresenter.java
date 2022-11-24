package Timer.TimerPresenters;

import Timer.TimerOutputBoundaries.TimerOutputBoundary;
import Timer.TimerUseCases.TimerResponseModel;

public class TimerPresenter implements TimerOutputBoundary {
    private TimerResponseModel tResponseModel;
    @Override
    public String displayTimer() {
        return tResponseModel.getOutputTime();
    }
}
