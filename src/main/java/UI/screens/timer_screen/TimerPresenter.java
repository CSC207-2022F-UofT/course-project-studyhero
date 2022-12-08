package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerOutputBoundary;
import Timer.timer_use_cases.TimerResponseModel;

/**
 * Presenter class for the timer.
 */
public class TimerPresenter implements TimerOutputBoundary {
    /**
     * Class that contains the information that will be displayed to the user.
     */
    final TimerResponseModel timerResponseModel;
    /**
     * The time that will be displayed to the user.
     */
    String outputTime;

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
        this.outputTime = timerResponseModel.getOutputTime();
        return outputTime;
    }
}
