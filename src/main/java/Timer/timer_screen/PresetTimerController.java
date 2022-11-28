package Timer.timer_screen;

import Timer.timer_use_cases.TimerInteractor;
import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;

import java.util.HashMap;

public class PresetTimerController {

    private TimerRequestModel tRequestModel;
    private TimerInteractor tInteractor;
    private HashMap<String, String> presetTimes = new HashMap<>();

    public PresetTimerController(TimerRequestModel tRequestModel, TimerResponseModel tResponseModel) {
        presetTimes.put("Short", "00:15:00");
        presetTimes.put("Medium", "00:30:00");
        presetTimes.put("Long", "1:00:00");
        this.tRequestModel = tRequestModel;
        this.tInteractor = new TimerInteractor(tRequestModel, tResponseModel);
    }

    public void startTimer() {
        tInteractor.startTimer();
    }

    public void endTimer() {
        tInteractor.endTimer();
    }

    public void selectShortTime() {
        tRequestModel.setSelectedTime(presetTimes.get("Short"));
    }

    public void selectMediumTime() {
        tRequestModel.setSelectedTime(presetTimes.get("Medium"));
    }

    public void selectLongTime() {
        tRequestModel.setSelectedTime(presetTimes.get("Long"));
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
