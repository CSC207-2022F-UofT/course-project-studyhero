package UI.screens.timer_screen;

import timer.timer_use_cases.TimerOutputBoundary;
import timer.timer_use_cases.TimerResponseModel;

/**
 * Presenter class for the timer.
 */
public class TimerPresenter implements TimerOutputBoundary {
    /**
     * Class that contains the information that will be displayed to the user.
     */
    TimerResponseModel timerResponseModel;

    /**
     * Constructor for TimerPresenter.
     * @param timerResponseModel class that stores the information to be displayed
     */
    public TimerPresenter(TimerResponseModel timerResponseModel) {
        this.timerResponseModel = timerResponseModel;
    }

    /**
     * Gets the time that should be displayed from the timerResponseModel.
     * @return the time that will be displayed
     */
    @Override
    public String getOutputTime() {
        return timerResponseModel.getOutputTime();
    }
}
