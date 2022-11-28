package Timer.TimerUseCases;

public class TimerRequestModel {
    private String inputTime;
    private String selectedTime;

    public TimerRequestModel() {
        this.inputTime = "-1";
    }

    public String getInputTime() {
        return this.inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getSelectedTime() {
        return this.selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }
}
