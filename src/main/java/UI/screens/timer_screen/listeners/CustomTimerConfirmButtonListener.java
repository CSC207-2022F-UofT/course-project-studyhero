package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.TimerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * Class for the ActionListener of CustomTimerConfirmButton.
 */
public class CustomTimerConfirmButtonListener implements ActionListener {
    private CustomTimerController ctController;
    private JFormattedTextField customTimerTextField;
    private JLabel timerText;
    private JProgressBar progressBar;
    private JLabel errorLabel;

    /**
     * Constructor for CustomTimerConfirmButtonListener.
     * @param ctController
     * @param customTimerTextField
     * @param timerText
     * @param progressBar
     * @param errorLabel
     */
    public CustomTimerConfirmButtonListener(CustomTimerController ctController,
                                            JFormattedTextField customTimerTextField, JLabel timerText,
                                            JProgressBar progressBar, JLabel errorLabel) {
        this.ctController = ctController;
        this.customTimerTextField = customTimerTextField;
        this.timerText = timerText;
        this.progressBar = progressBar;
        this.errorLabel = errorLabel;
    }


    /**
     * Makes the timer use the entered time if the entered time matches the regex, otherwise "Invalid Time" will be
     * displayed, when the button is clicked.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String inputTime = customTimerTextField.getText();
        if (Pattern.matches("^[0-9]{2}:[0-5][0-9]:[0-5][0-9]$", inputTime)) {
            ctController.setCustomTime(inputTime);
            timerText.setText(inputTime);
            int totalSeconds = TimerPanel.convertTimeToSeconds(inputTime);
            progressBar.setMaximum(totalSeconds);
            errorLabel.setText("");
        }
        else {
            errorLabel.setForeground(Color.RED);
            errorLabel.setText("Invalid Time");
        }
    }
}
