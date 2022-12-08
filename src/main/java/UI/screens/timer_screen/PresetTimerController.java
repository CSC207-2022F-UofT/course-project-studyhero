package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerInteractor;
import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;

import java.util.HashMap;

public class PresetTimerController {

    private TimerRequestModel timerRequestModel;
    private TimerInteractor timerInteractor;
    private HashMap<String, String> presetTimes = new HashMap<>();

    public PresetTimerController(TimerRequestModel timerRequestModel, TimerResponseModel timerResponseModel) {
        presetTimes.put("Short", "00:15:00");
        presetTimes.put("Medium", "00:30:00");
        presetTimes.put("Long", "01:00:00");
        this.timerRequestModel = timerRequestModel;
        this.timerInteractor = new TimerInteractor(timerRequestModel, timerResponseModel);
    }

    public void startTimer() {
        timerInteractor.startTimer();
    }

    public void endTimer() {
        timerInteractor.endTimer();
    }

    public void selectShortTime() {
        timerRequestModel.setSelectedTime(presetTimes.get("Short"));
    }

    public void selectMediumTime() {
        timerRequestModel.setSelectedTime(presetTimes.get("Medium"));
    }

    public void selectLongTime() {
        timerRequestModel.setSelectedTime(presetTimes.get("Long"));
    }

    public String getShortTime() {
        return presetTimes.get("Short");
    }

    public String getMediumTime() {
        return presetTimes.get("Medium");
    }

    public String getLongTime() {
        return presetTimes.get("Long");
    }
}
