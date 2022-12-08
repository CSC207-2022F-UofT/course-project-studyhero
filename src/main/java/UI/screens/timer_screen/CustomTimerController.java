package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerInteractor;
import Timer.timer_use_cases.TimerResponseModel;

public class CustomTimerController {
    private TimerRequestModel timerRequestModel;
    private TimerInteractor timerInteractor;

    public CustomTimerController(TimerRequestModel timerRequestModel, TimerResponseModel timerResponseModel) {
        this.timerRequestModel = timerRequestModel;
        this.timerInteractor = new TimerInteractor(timerRequestModel, timerResponseModel);
    }

    public void setCustomTime(String time) {
        timerRequestModel.setCustomTime(time);
    }
    public String getCustomTime() {
        return timerRequestModel.getCustomTime();
    }

    public void startTimer() {
        timerInteractor.startTimer();
    }
    public void endTimer() {
        timerInteractor.endTimer();
    }
}
