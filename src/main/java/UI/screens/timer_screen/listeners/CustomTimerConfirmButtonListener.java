package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;

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
            int totalSeconds = convertTimeToSeconds(inputTime);
            progressBar.setMaximum(totalSeconds);
            errorLabel.setText("");
        }
        else {
            errorLabel.setForeground(Color.RED);
            errorLabel.setText("Invalid Time");
        }
    }

    /**
     * Helper method that converts String time into the number of seconds that it equals.
     * @param time the time with format (00:00:00)
     * @return the number of seconds time equals
     */
    public int convertTimeToSeconds(String time) {
        String[] times = time.split(":", 3);
        int timeSeconds = Integer.parseInt(times[0])*3600 + Integer.parseInt(times[1])*60 + Integer.parseInt(times[2]);
        return timeSeconds;
    }
}
