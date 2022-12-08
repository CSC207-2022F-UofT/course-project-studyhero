package Timer.timer_use_cases;

import Timer.timer_entity.TimerEntity;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Represents a timer interactor.
 */
public class TimerInteractor implements TimerInputBoundary {

    final TimerRequestModel timerRequestModel;
    final TimerResponseModel timerResponseModel;
    TimerEntity timerEntity = new TimerEntity();

    public TimerInteractor(TimerRequestModel timerRequestModel, TimerResponseModel timerResponseModel) {
        this.timerRequestModel = timerRequestModel;
        this.timerResponseModel = timerResponseModel;
    }

    @Override
    public void startTimer() {
        timerEntity = new TimerEntity();
        if (timerRequestModel.getCustomTime().equals("-1")) {
            timerEntity.setTimer(convertTimeToArray(timerRequestModel.getSelectedTime()));
        }
        else {
            timerEntity.setTimer(convertTimeToArray(timerRequestModel.getCustomTime()));
        }
        timerEntity.startTimer();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timerResponseModel.setOutputTime(timerEntity.timeLeft);
            }
        }, 0, 100);
    }

    @Override
    public void endTimer() {
        timerEntity.endTimer();
        timerResponseModel.setElapsedTime(timerResponseModel.getElapsedTime() + timerEntity.getElapsedTime());
        timerEntity = null;
    }

    /**
     * @param time
     */
    @Override
    public void setTimer(int[] time) {
        timerEntity.setTimer(time);
    }

    private int[] convertTimeToArray(String inputTime) {
        int[] convertedTime = new int[3];
        String[] times = inputTime.split(":", 3);
        convertedTime[0] = Integer.parseInt(times[0]);
        convertedTime[1] = Integer.parseInt(times[1]);
        convertedTime[2] = Integer.parseInt(times[2]);
        return convertedTime;
    }
}
