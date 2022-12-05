package Timer.TimerControllers;

import Timer.TimerUseCases.CustomTimerRequestModel;
import Timer.TimerUseCases.TimerInteractor;

public class CustomTimerController {
    private TimerInteractor tInteractor;

    public CustomTimerRequestModel getCustomTime(String time) {
        return new CustomTimerRequestModel(time);
    }

    public void startTimer() {
        tInteractor.startTimer();
    }
}
