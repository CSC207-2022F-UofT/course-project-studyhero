package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.ConvertTimeToSecondsHelper;
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
    CustomTimerController ctController;
    JFormattedTextField customTimerTextField;
    JLabel timerText;
    JProgressBar progressBar;
    JLabel errorLabel;

    /**
     * Constructor for CustomTimerConfirmButtonListener.
     * @param ctController the CustomTimerController
     * @param customTimerTextField the text field on the timer screen
     * @param timerText the label displaying the time
     * @param progressBar the progress bar on the timer screen
     * @param errorLabel the label that shows when an invalid time is entered
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
        ConvertTimeToSecondsHelper helper = new ConvertTimeToSecondsHelper();
        String inputTime = customTimerTextField.getText();
        if (Pattern.matches("^[0-9]{2}:[0-5][0-9]:[0-5][0-9]$", inputTime)) {
            ctController.setCustomTime(inputTime);
            timerText.setText(inputTime);
            int totalSeconds = helper.convertTimeToSeconds(inputTime);
            progressBar.setMaximum(totalSeconds);
            errorLabel.setText("");
        }
        else {
            errorLabel.setForeground(Color.RED);
            errorLabel.setText("Invalid Time");
        }
    }
}
