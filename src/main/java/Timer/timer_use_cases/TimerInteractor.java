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
    TimerEntity timerEntity = new TimerEntity();

    public TimerInteractor(TimerRequestModel tRequestModel, TimerResponseModel tResponseModel) {
        this.tRequestModel = tRequestModel;
        this.tResponseModel = tResponseModel;
    }

    @Override
    public void startTimer() {
        timerEntity = new TimerEntity();
        if (tRequestModel.getCustomTime().equals("-1")) {
            timerEntity.startingTime = convertTime(tRequestModel.getSelectedTime());
        }
        else {
            timerEntity.startingTime = convertTime(tRequestModel.getCustomTime());
        }
        timerEntity.startTimer();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tResponseModel.setOutputTime(timerEntity.timeLeft);
            }
        }, 0, 100);
    }

    @Override
    public void endTimer() {
        timerEntity.endTimer();
    }

    /**
     * @param time
     */
    @Override
    public void setTimer(int[] time) {
        timerEntity.setTimer(time);
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
