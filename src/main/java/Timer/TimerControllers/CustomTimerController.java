package Timer.TimerControllers;

import Timer.TimerUseCases.TimerRequestModel;
import Timer.TimerUseCases.TimerInteractor;
import Timer.TimerUseCases.TimerResponseModel;

public class CustomTimerController {
    private TimerRequestModel tRequestModel;
    private TimerInteractor tInteractor;

    public CustomTimerController(TimerRequestModel tRequestModel, TimerResponseModel tResponseModel) {
        this.tRequestModel = tRequestModel;
        this.tInteractor = new TimerInteractor(tRequestModel, tResponseModel);
    }

    public void getCustomTime(String time) {
        tRequestModel.setInputTime(time);
    }

    public void startTimer() {
        tInteractor.startTimer();
    }
    public void endTimer() {
        tInteractor.endTimer();
    }
}
