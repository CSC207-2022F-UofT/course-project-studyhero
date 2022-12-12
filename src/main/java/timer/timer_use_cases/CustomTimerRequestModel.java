package timer.timer_use_cases;

public class CustomTimerRequestModel {
    /**
     * The time that the user entered.
     */
    private String inputTime = "-1";

    /**
     * Gets the time that the user entered.
     * @return the time that the user entered
     */
    public String getCustomTime() {
        return this.inputTime;
    }

    /**
     * Sets the time that the user entered.
     * @param inputTime the time that the user entered
     */
    public void setCustomTime(String inputTime) {
        this.inputTime = inputTime;
    }
}
