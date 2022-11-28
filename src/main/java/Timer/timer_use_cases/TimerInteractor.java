package Timer.timer_use_cases;

import Timer.timer_entity.TimerEntity;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Represents a timer interactor.
 */
public class TimerInteractor implements TimerInputBoundary {

    final TimerRequestModel tRequestModel;
    final TimerResponseModel tResponseModel;

    public TimerInteractor(TimerRequestModel tRequestModel, TimerResponseModel tResponseModel) {
        this.tRequestModel = tRequestModel;
        this.tResponseModel = tResponseModel;
    }

    @Override
    public void startTimer() {
        if (tRequestModel.getInputTime().equals("-1")) {
            TimerEntity.startingTime = convertTime(tRequestModel.getSelectedTime());
        }
        else {
            TimerEntity.startingTime = convertTime(tRequestModel.getInputTime());
        }
        TimerEntity.startTimer();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tResponseModel.setOutputTime(TimerEntity.timeLeft);
            }
        }, 0, 1000);
    }

    @Override
    public void endTimer() {
        TimerEntity.endTimer();
    }

    /**
     * @param time
     */
    @Override
    public void setTimer(int[] time) {
        TimerEntity.setTimer(time);
    }

    private String updateTime() {
        return TimerEntity.timeLeft;
    }

    private int[] convertTime(String inputTime) {
        int[] convertedTime = new int[3];
        String[] times = inputTime.split(":", 3);
        convertedTime[0] = Integer.parseInt(times[0]);
        convertedTime[1] = Integer.parseInt(times[1]);
        convertedTime[2] = Integer.parseInt(times[2]);
        return convertedTime;
    }
}
