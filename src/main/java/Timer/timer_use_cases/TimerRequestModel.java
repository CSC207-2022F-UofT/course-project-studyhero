package Timer.timer_use_cases;

public class TimerRequestModel {
    private String selectedTime;
    private String inputTime;

    public TimerRequestModel() {
        this.inputTime = "-1";
    }

    public String getCustomTime() {
        return this.inputTime;
    }

    public void setCustomTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getSelectedTime() {
        return this.selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }
}
