package Timer.timer_use_cases;

/**
 * Class that stores the time that the user entered or selected from the preset times.
 */
public class TimerRequestModel {
    /**
     * The time that the user selected from the preset times.
     */
    private String selectedTime;
    /**
     * The time that the user entered.
     */
    private String inputTime;

    /**
     * Constructor for TimerRequestModel class, the input time is set to -1 by default
     * so later methods can decide if selectedTime or inputTime should be used.
     */
    public TimerRequestModel() {
        this.inputTime = "-1";
    }

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

    /**
     * Gets the time that the user selected.
     * @return the time that the user selected
     */
    public String getSelectedTime() {
        return this.selectedTime;
    }

    /**
     * Sets the time that the user selected.
     * @param selectedTime the time that the user selected
     */
    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }
}
