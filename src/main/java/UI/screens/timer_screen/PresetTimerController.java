package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerInteractor;
import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;

import java.util.HashMap;

/**
 * Controller class for the preset portion of the timer.
 */
public class PresetTimerController {
    /**
     * The class that stores the inputs from the user.
     */
    TimerRequestModel timerRequestModel;
    /**
     * The class that stores the information that will be displayed back to the user.
     */
    TimerInteractor timerInteractor;
    /**
     * The preset times that the user can choose from.
     */
    HashMap<String, String> presetTimes = new HashMap<>();

    /**
     * Constructor for PresetTimerController. It adds the mappings for the different times
     * that the user can choose from.
     * @param timerRequestModel class that stores the inputs from the user
     * @param timerResponseModel class that stores the information that will be displayed back to the user
     */
    public PresetTimerController(TimerRequestModel timerRequestModel, TimerResponseModel timerResponseModel) {
        presetTimes.put("Short", "00:15:00");
        presetTimes.put("Medium", "00:30:00");
        presetTimes.put("Long", "01:00:00");
        this.timerRequestModel = timerRequestModel;
        this.timerInteractor = new TimerInteractor(timerRequestModel, timerResponseModel);
    }

    /**
     * Starts the timer using the startTimer method of timerInteractor.
     */
    public void startTimer() {
        timerInteractor.startTimer();
    }

    /**
     * End the timer using the startTimer method of timerInteractor.
     */
    public void endTimer() {
        timerInteractor.endTimer();
    }

    /**
     * Sets the selected time in timerRequestModel to the time that is mapped to "Short" in presetTimes.
     */
    public void selectShortTime() {
        timerRequestModel.setSelectedTime(presetTimes.get("Short"));
    }

    /**
     * Sets the selected time in timerRequestModel to the time that is mapped to "Medium" in presetTimes.
     */
    public void selectMediumTime() {
        timerRequestModel.setSelectedTime(presetTimes.get("Medium"));
    }

    /**
     * Sets the selected time in timerRequestModel to the time that is mapped to "Long" in presetTimes.
     */
    public void selectLongTime() {
        timerRequestModel.setSelectedTime(presetTimes.get("Long"));
    }

    /**
     * Gets the time that is mapped to "Short" in presetTimes.
     * @return the time that is mapped to "Short" in presetTimes as a String
     */
    public String getShortTime() {
        return presetTimes.get("Short");
    }

    /**
     * Gets the time that is mapped to "Medium" in presetTimes.
     * @return the time that is mapped to "Medium" in presetTimes as a String
     */
    public String getMediumTime() {
        return presetTimes.get("Medium");
    }

    /**
     * Gets the time that is mapped to "Long" in presetTimes.
     * @return the time that is mapped to "Long" in presetTimes as a String
     */
    public String getLongTime() {
        return presetTimes.get("Long");
    }
}
