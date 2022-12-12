package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class CustomTimerConfirmButtonListener implements ActionListener {
    private CustomTimerController ctController;
    private JFormattedTextField customTimerTextField;
    private JLabel timerText;
    private JProgressBar progressBar;
    private JLabel errorLabel;

    public CustomTimerConfirmButtonListener(CustomTimerController ctController, JFormattedTextField customTimerTextField, JLabel timerText, JProgressBar progressBar, JLabel errorLabel) {
        this.ctController = ctController;
        this.customTimerTextField = customTimerTextField;
        this.timerText = timerText;
        this.progressBar = progressBar;
        this.errorLabel = errorLabel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String inputTime = customTimerTextField.getText();
        if (Pattern.matches("^[0-9]{2}:[0-5][0-9]:[0-5][0-9]$", inputTime)) {
            ctController.setCustomTime(inputTime);
            timerText.setText(inputTime);
            int totalSeconds = TimerPanel.convertTimeToInt(inputTime);
            progressBar.setMaximum(totalSeconds);
            errorLabel.setText("");
        }
        else {
            errorLabel.setForeground(Color.RED);
            errorLabel.setText("Invalid Time");
        }
    }
}
