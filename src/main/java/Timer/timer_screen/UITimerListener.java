package Timer.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Timer.timer_screen.TimerPanel.convertTimeToInt;

public class UITimerListener implements ActionListener {
    private JLabel timerText;
    private TimerPresenter tPresenter;
    private JProgressBar progressBar;
    private Timer timer;
    private JButton goToBreakMenuButton;

    public UITimerListener(JLabel timerText, TimerPresenter tPresenter, JProgressBar progressBar, Timer timer, JButton goToBreakMenuButton) {
        this.timerText = timerText;
        this.tPresenter = tPresenter;
        this.progressBar = progressBar;
        this.timer = timer;
        this.goToBreakMenuButton = goToBreakMenuButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timerText.setText(tPresenter.getOutputTime());
        progressBar.setValue(progressBar.getMaximum() - convertTimeToInt(tPresenter.getOutputTime()));
        if ((tPresenter.getOutputTime()).equals("00:00:00")) {
            timer.stop();
            goToBreakMenuButton.setVisible(true);
        }
        else {
            goToBreakMenuButton.setVisible(false);
        }
    }
}
