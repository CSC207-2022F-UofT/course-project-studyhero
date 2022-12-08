package Timer.timer_entity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Entity class for the timer.
 */
public class TimerEntity {
    /**
     * The time that the timer starts at.
     */
    public int[] startingTime = new int[3];
    /**
     * The amount of time left.
     */
    public String timeLeft = "00:00:00";
    /**
     * Initialize a new timer.
     */
    private Timer timer  = new Timer();
    /**
     * The total time that has elapsed.
     */
    private int elapsedTime = 0;

    /**
     * Starts the timer using timerTask. The elapsed time is updated every second and the timer will end automatically
     * when the time reaches 00:00:00.
     */
    public void startTimer() {
        TimerTask timerTask = new TimerTask() {
            int seconds = startingTime[2];
            int minutes = startingTime[1];
            int hours = startingTime[0];
            @Override
            public void run() {
                updateTime(hours, minutes, seconds);
                elapsedTime++;
                seconds--;
                if (seconds < 0) {
                    minutes--;
                    if (minutes < 0) {
                        hours--;
                        if (hours < 0) {
                            timer.cancel();
                        }
                        minutes = 59;
                    }
                    seconds = 59;
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

    }

    /**
     * Sets the starting time of the timer.
     *
     * @param time The new time that the timer starts at.
     */
    public void setTimer(int[] time) {
        startingTime = time;
    }

    /**
     * Ends the timer.
     */
    public void endTimer() {
        timer.cancel();
        timer.purge();
    }

    /**
     * Helper method that updates timeLeft while the timer is running.
     * @param hours the number of hours left
     * @param minutes the number of minutes left
     * @param seconds the number of seconds left
     */
    public void updateTime(int hours, int minutes, int seconds) {
        timeLeft = String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }

    /**
     * Gets the elapsed time.
     * @return the elapsed time
     */
    public int getElapsedTime() {
        return elapsedTime;
    }
}
