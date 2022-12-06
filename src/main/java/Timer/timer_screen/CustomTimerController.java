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

    public void setCustomTime(String time) {
        tRequestModel.setCustomTime(time);
    }
    public String getCustomTime() {
        return tRequestModel.getCustomTime();
    }

    public void startTimer() {
        tInteractor.startTimer();
    }
    public void endTimer() {
        tInteractor.endTimer();
    }
}
