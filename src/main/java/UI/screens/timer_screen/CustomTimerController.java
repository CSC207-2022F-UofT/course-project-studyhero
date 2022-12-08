package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerInteractor;
import Timer.timer_use_cases.TimerResponseModel;

/**
 * Controller class for the custom portion of the timer.
 */
public class CustomTimerController {
    /**
     * The class that stores the inputs from the user.
     */
    TimerRequestModel timerRequestModel;
    /**
     * The TimerInteractor class.
     */
    TimerInteractor timerInteractor;

    /**
     * Constructor for CustomTimerController.
     * @param timerRequestModel class that stores the inputs from the user
     * @param timerResponseModel class that stores the information that will be displayed back to the user
     */
    public CustomTimerController(TimerRequestModel timerRequestModel, TimerResponseModel timerResponseModel) {
        this.timerRequestModel = timerRequestModel;
        this.timerInteractor = new TimerInteractor(timerRequestModel, timerResponseModel);
    }

    /**
     * Sets the customTime in timerRequestModel to time.
     * @param time the time that the user entered
     */
    public void setCustomTime(String time) {
        timerRequestModel.setCustomTime(time);
    }

    /**
     * Gets the customTime from timerRequestModel.
     * @return the customTime from timerRequestModel
     */
    public String getCustomTime() {
        return timerRequestModel.getCustomTime();
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
}
