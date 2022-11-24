package Timer.TimerUseCases;

import Timer.TimerInputBoundaries.TimerInputBoundary;
import Timer.TimerEntities.TimerEntity;

/**
 * Represents a timer interactor.
 */
public class TimerInteractor implements TimerInputBoundary {

    final CustomTimerRequestModel cTRequestModel;

    public TimerInteractor(CustomTimerRequestModel cTRequestModel) {
        this.cTRequestModel = cTRequestModel;
        //this.tResponseModel = tResponseModel;
    }
    @Override
    public void startTimer() {
        TimerEntity.startingTime = convertTime(cTRequestModel.getInputTime());
        TimerEntity.startTimer();
        //tResponseModel.setOutputTime(TimerEntity.timeLeft);
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

    private int[] convertTime(String inputTime) {
        int[] convertedTime = new int[3];
        String[] times = inputTime.split(":", 2);
        convertedTime[0] = Integer.parseInt(times[0]);
        convertedTime[1] = Integer.parseInt(times[1]);
        convertedTime[2] = Integer.parseInt(times[2]);
        return convertedTime;
    }
}
