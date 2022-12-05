package Timer.TimerUseCases;

public class TimerResponseModel {
    private String outputTime;

    public TimerResponseModel(String outputTime) {
        this.outputTime = outputTime;
    }

    public String getOutputTime() {
        return this.outputTime;
    }

    void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
    }
}
