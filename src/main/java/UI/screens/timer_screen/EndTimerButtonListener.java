package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTimerButtonListener implements ActionListener {
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private Timer timer;
    private JLabel timerText;
    private JButton goToBreakMenuButton;

    public EndTimerButtonListener(PresetTimerController ptController, CustomTimerController ctController, Timer timer, JLabel timerText, JButton goToBreakMenuButton) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timer = timer;
        this.timerText = timerText;
        this.goToBreakMenuButton = goToBreakMenuButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ctController.getCustomTime().equals("-1")) {
            ptController.endTimer();
        }
        else {
            ctController.endTimer();
        }
        timer.stop();
        timerText.setText("00:00:00");
        goToBreakMenuButton.setVisible(true);
    }
}
