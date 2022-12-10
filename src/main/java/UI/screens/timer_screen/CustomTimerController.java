package UI.screens.timer_screen;

import Timer.timer_use_cases.CustomTimerRequestModel;
import Timer.timer_use_cases.TimerInteractor;

/**
 * Controller class for the custom portion of the timer.
 */
public class CustomTimerController {
    /**
     * The class that stores the inputs from the user.
     */
    CustomTimerRequestModel customTimerRequestModel = new CustomTimerRequestModel();
    /**
     * The TimerInteractor class.
     */
    TimerInteractor timerInteractor;

    /**
     * Constructor for CustomTimerController.
     * @param timerInteractor the Interactor that is used by the controller
     */
    public CustomTimerController(TimerInteractor timerInteractor) {
        this.timerInteractor = timerInteractor;
    }

    /**
     * Starts the timer using the startTimer method of timerInteractor.
     */
    public void startTimer() {
        timerInteractor.setTimer(customTimerRequestModel.getCustomTime());
        timerInteractor.startTimer();
    }

    /**
     * End the timer using the startTimer method of timerInteractor.
     */
    public void endTimer() {
        timerInteractor.endTimer();
    }

    /**
     * Sets the customTime in timerRequestModel to time.
     * @param time the time that the user entered
     */
    public void setCustomTime(String time) {
        customTimerRequestModel.setCustomTime(time);
    }

    /**
     * Gets the customTime from timerRequestModel.
     * @return the customTime from timerRequestModel
     */
    public String getCustomTime() {
        return customTimerRequestModel.getCustomTime();
    }
}
