package Timer.timer_use_cases;

/**
 * Class that stores the time that the user entered or selected from the preset times.
 */
public class PresetTimerRequestModel {
    /**
     * The time that the user selected from the preset times.
     */
    private String selectedTime;

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
