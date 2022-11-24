package Timer.TimerControllers;

import java.util.Dictionary;

public class PresetTimerController {
    private Dictionary presetTimes;
    public PresetTimerController() {
        presetTimes.put("Short", "00:15:00");
        presetTimes.put("Medium", "00:30:00");
        presetTimes.put("Long", "1:00:00");
    }

    private void useCustomTime() {

    }
}
