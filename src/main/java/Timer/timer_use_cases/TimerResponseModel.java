package Timer.timer_use_cases;

public class TimerResponseModel {
    private String outputTime = "00:00:00";

    public String getOutputTime() {
        return this.outputTime;
    }

    void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
    }
}
