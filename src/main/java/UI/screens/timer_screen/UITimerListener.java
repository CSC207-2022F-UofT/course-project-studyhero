package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static UI.screens.timer_screen.TimerPanel.convertTimeToInt;

public class UITimerListener implements ActionListener {
    private JLabel timerText;
    private TimerPresenter tPresenter;
    private JProgressBar progressBar;
    private JButton goToBreakMenuButton;

    public UITimerListener(JLabel timerText, TimerPresenter tPresenter, JProgressBar progressBar, JButton goToBreakMenuButton) {
        this.timerText = timerText;
        this.tPresenter = tPresenter;
        this.progressBar = progressBar;
        this.goToBreakMenuButton = goToBreakMenuButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timerText.setText(tPresenter.updateTimer());
        progressBar.setValue(progressBar.getMaximum() - convertTimeToInt(tPresenter.updateTimer()));
        if ((tPresenter.updateTimer()).equals("00:00:00")) {
            goToBreakMenuButton.setVisible(true);
        }
        else {
            goToBreakMenuButton.setVisible(false);
        }
    }
}
