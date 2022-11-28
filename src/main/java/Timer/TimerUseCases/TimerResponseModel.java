package Timer.TimerUseCases;

public class TimerResponseModel {
    private String outputTime = "00:00:00";

    public String getOutputTime() {
        return this.outputTime;
    }

    void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
    }
}
