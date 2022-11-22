package Timer.TimerUseCases;

public class CustomTimerRequestModel {
    private String inputTime;

    public CustomTimerRequestModel(String inputTime) {
        this.inputTime = inputTime;
    }

    String getInputTime() {
        return this.inputTime;
    }

    void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }
}
