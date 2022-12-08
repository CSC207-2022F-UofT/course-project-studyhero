package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;
import UI.screens.timer_screen.listeners.*;

import javax.swing.*;
import java.awt.*;

public class TimerPanel extends JPanel {
    private JPanel mainPanel;
    private JLabel timerText;
    private JProgressBar progressBar;
    private JButton presetShortButton;
    private JButton customTimerConfirmButton;
    private JButton presetLongButton;
    private JButton presetMediumButton;
    private JButton startTimerButton;
    private JButton endTimerButton;
    private JFormattedTextField customTimerTextField;
    private JLabel errorLabel;
    private JButton breakMenuButton;

    private Timer timer;

    CardLayout card;
    JPanel parentPanel;

    TimerRequestModel timerRequestModel = new TimerRequestModel();
    TimerResponseModel timerResponseModel = new TimerResponseModel();
    CustomTimerController customTimerController = new CustomTimerController(timerRequestModel, timerResponseModel);
    PresetTimerController presetTimerController = new PresetTimerController(timerRequestModel, timerResponseModel);
    TimerPresenter timerPresenter = new TimerPresenter(timerResponseModel);

    public TimerPanel(CardLayout card, JPanel parentPanel) {
        progressBar.setMinimum(0);
        progressBar.setValue(0);

        timerText.setFont(new Font("Verdana", Font.PLAIN, 48));

        timer = new Timer(100, new UITimerListener(timerText, timerPresenter, progressBar, breakMenuButton, customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField));

        this.card = card;
        this.parentPanel = parentPanel;

        this.add(mainPanel);

        addListeners();
    }

    public static int convertTimeToSeconds(String time) {
        String[] times = time.split(":", 3);
        int timeSeconds = Integer.parseInt(times[0])*3600 + Integer.parseInt(times[1])*60 + Integer.parseInt(times[2]);
        return timeSeconds;
    }

    public void addListeners() {
        startTimerButton.addActionListener(new StartTimerButtonListener(presetTimerController, customTimerController, timer, customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField));
        endTimerButton.addActionListener(new EndTimerButtonListener(presetTimerController, customTimerController, timer, timerText, breakMenuButton, customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField));
        presetShortButton.addActionListener(new PresetShortButtonListener(presetTimerController, customTimerController, timerText, progressBar));
        presetMediumButton.addActionListener(new PresetMediumButtonListener(presetTimerController, customTimerController, timerText, progressBar));
        presetLongButton.addActionListener(new PresetLongButtonListener(presetTimerController, customTimerController, timerText, progressBar));
        customTimerConfirmButton.addActionListener(new CustomTimerConfirmButtonListener(customTimerController, customTimerTextField, timerText, progressBar, errorLabel));
        customTimerTextField.addKeyListener(new CustomTimerTextFieldKeyListener(customTimerTextField));
        customTimerTextField.addCaretListener(new CustomTimerTextFieldCaretListener(customTimerTextField));
        customTimerTextField.addFocusListener(new CustomTimerTextFieldFocusListener(customTimerTextField));
        breakMenuButton.addActionListener(new BreakMenuButtonListener(card, parentPanel));
    }
}

