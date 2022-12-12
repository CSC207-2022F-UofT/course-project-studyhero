package Timer.timer_use_cases;

public class TimerResponseModel {
    private String outputTime = "00:00:00";

    private int elapsedTime = 0;

    public String getOutputTime() {
        return this.outputTime;
    }

    void setOutputTime(String outputTime) {
        this.outputTime = outputTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
