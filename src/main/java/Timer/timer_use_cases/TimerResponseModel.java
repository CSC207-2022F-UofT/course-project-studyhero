package Timer.timer_use_cases;

/**
 * Class that stores the time that should be displayed to the user and how long the user has studied for.
 */
public class TimerResponseModel {
    /**
     * The time that will be displayed to the user.
     */
    private String outputTime = "00:00:00";

    /**
     * The total amount of time that the user has elapsed.
     */
    private int elapsedTime = 0;

    /**
     * Gets the time that will be displayed to the user.
     * @return display time
     */
    public String getOutputTime() {
        return this.outputTime;
    }

    /**
     * Sets the time that will be displayed to the user.
     * @param outputTime display time
     */
    void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
    }

    /**
     * Gets the time elapsed from the timer.
     * @return time elapsed
     */
    public int getElapsedTime() {
        return elapsedTime;
    }

    /**
     * Sets the time elapsed from the timer.
     * @param elapsedTime the time elapsed
     */
    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
