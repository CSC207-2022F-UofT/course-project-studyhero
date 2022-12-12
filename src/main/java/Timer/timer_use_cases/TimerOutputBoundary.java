package Timer.timer_use_cases;

/**
 * Output boundary interface to be used by the timer controller.
 */
public interface TimerOutputBoundary {
    /**
     * Method that gets the time that will be displayed to the user.
     * @return the display time
     */
    String getOutputTime();
}
