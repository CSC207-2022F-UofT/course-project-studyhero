package Timer.timer_use_cases;

/**
 * Input boundary interface to be used by the timer interactor.
 */
public interface TimerInputBoundary {
    /**
     * Method to start the timer.
     */
    void startTimer();

    /**
     * Method to end the timer.
     */
    void endTimer();

    /**
     * Method to set the starting time of timer.
     * @param time the starting time
     */
    void setTimer(int[] time);
}
