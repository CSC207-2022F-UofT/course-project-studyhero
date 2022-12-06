package Timer.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartTimerButtonListener implements ActionListener {
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private Timer timer;

    public StartTimerButtonListener(PresetTimerController ptController, CustomTimerController ctController, Timer timer) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timer = timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ctController.getCustomTime().equals("-1")) {
            ptController.startTimer();
        } else {
            ctController.startTimer();
        }
        timer.start();
    }
}
