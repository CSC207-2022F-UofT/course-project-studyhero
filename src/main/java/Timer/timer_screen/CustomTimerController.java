package Timer.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerInteractor;
import Timer.timer_use_cases.TimerResponseModel;

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
