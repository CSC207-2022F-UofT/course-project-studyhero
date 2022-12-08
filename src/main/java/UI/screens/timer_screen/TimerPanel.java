package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;
import UI.screens.timer_screen.listeners.*;

import javax.swing.*;
import java.awt.*;

/**
 * Class for the panel that contains the timer. It is part of the UI.
 */
public class TimerPanel extends JPanel {
    /**
     * The elements on TimerPanel.
     */
    JPanel mainPanel;
    JLabel timerText;
    JProgressBar progressBar;
    JButton presetShortButton;
    JButton customTimerConfirmButton;
    JButton presetLongButton;
    JButton presetMediumButton;
    JButton startTimerButton;
    JButton endTimerButton;
    JFormattedTextField customTimerTextField;
    JLabel errorLabel;
    JButton breakMenuButton;
    Timer timer;
    /**
     * Layout that allows the user to switch between panels.
     */
    CardLayout card;
    /**
     * The panel that contains TimerPanel.
     */
    JPanel parentPanel;
    TimerRequestModel timerRequestModel = new TimerRequestModel();
    TimerResponseModel timerResponseModel = new TimerResponseModel();
    CustomTimerController customTimerController = new CustomTimerController(timerRequestModel, timerResponseModel);
    PresetTimerController presetTimerController = new PresetTimerController(timerRequestModel, timerResponseModel);
    TimerPresenter timerPresenter = new TimerPresenter(timerResponseModel);

    /**
     * Constructor for TimerPanel. Sets up various elements on the panel and adds listeners to them using helper method
     * addListeners.
     * @param card
     * @param parentPanel
     */
    public TimerPanel(CardLayout card, JPanel parentPanel) {
        progressBar.setMinimum(0);
        progressBar.setValue(0);
        endTimerButton.setEnabled(false);

        timerText.setFont(new Font("Verdana", Font.PLAIN, 48));

        timer = new Timer(100, new UITimerListener(timerText, timerPresenter, progressBar, breakMenuButton,
                customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton, startTimerButton,
                customTimerTextField, endTimerButton));

        this.card = card;
        this.parentPanel = parentPanel;

        this.add(mainPanel);

        addListeners();
    }

    /**
     * Helper method that converts String time into the number of seconds that it equals.
     * @param time the time with format (00:00:00)
     * @return the number of seconds time equals
     */
    public static int convertTimeToSeconds(String time) {
        String[] times = time.split(":", 3);
        int timeSeconds = Integer.parseInt(times[0])*3600 + Integer.parseInt(times[1])*60 + Integer.parseInt(times[2]);
        return timeSeconds;
    }

    /**
     * Helper method that initializes and adds Listener classes to the corresponding elements on the panel.
     */
    public void addListeners() {
        startTimerButton.addActionListener(new StartTimerButtonListener(presetTimerController, customTimerController,
                timer, customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton,
                startTimerButton, customTimerTextField, endTimerButton));
        endTimerButton.addActionListener(new EndTimerButtonListener(presetTimerController, customTimerController, timer,
                timerText, breakMenuButton, customTimerConfirmButton, presetLongButton, presetMediumButton,
                presetShortButton, startTimerButton, customTimerTextField, endTimerButton));
        presetShortButton.addActionListener(new PresetShortButtonListener(presetTimerController, customTimerController,
                timerText, progressBar));
        presetMediumButton.addActionListener(new PresetMediumButtonListener(presetTimerController,
                customTimerController, timerText, progressBar));
        presetLongButton.addActionListener(new PresetLongButtonListener(presetTimerController, customTimerController,
                timerText, progressBar));
        customTimerConfirmButton.addActionListener(new CustomTimerConfirmButtonListener(customTimerController,
                customTimerTextField, timerText, progressBar, errorLabel));
        customTimerTextField.addKeyListener(new CustomTimerTextFieldKeyListener(customTimerTextField));
        customTimerTextField.addCaretListener(new CustomTimerTextFieldCaretListener(customTimerTextField));
        customTimerTextField.addFocusListener(new CustomTimerTextFieldFocusListener(customTimerTextField));
        breakMenuButton.addActionListener(new BreakMenuButtonListener(card, parentPanel));
    }
}

