package Timer.timer_entity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents a timer entity.
 */
public class TimerEntity {
    /**
     * The time that the timer counts down from.
     */
    public static int[] startingTime = new int[3];
    /**
     * The amount of time left.
     */
    public static String timeLeft = "00:00:00";
    private static Timer timer = new Timer();

    /**
     * Starts the timer.
     */
    public static void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            int seconds = TimerEntity.startingTime[2];
            int minutes = TimerEntity.startingTime[1];
            int hours = TimerEntity.startingTime[0];
            @Override
            public void run() {
                updateTime(hours, minutes, seconds);
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
        }, 0, 1000);
    }

    /**
     * Sets the starting time of the timer.
     *
     * @param time The new time that the timer starts at.
     */
    public static void setTimer(int[] time) {
        startingTime = time;
    }

    /**
     * Ends the timer.
     */
    public static void endTimer() {
        timer.cancel();
    }

    public static void updateTime(int hours, int minutes, int seconds) {
        timeLeft = String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }
}
