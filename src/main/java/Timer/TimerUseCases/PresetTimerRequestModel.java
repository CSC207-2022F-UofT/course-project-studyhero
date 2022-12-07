package Timer.TimerUseCases;

public class PresetTimerRequestModel {
    private String selectedTime;

    public PresetTimerRequestModel(String selectedTime) {
        this.selectedTime = selectedTime;
    }

    String getSelectedTime() {
        return this.selectedTime;
    }

    void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }
}
