package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;

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

    TimerRequestModel tRequestModel = new TimerRequestModel();
    TimerResponseModel tResponseModel = new TimerResponseModel();
    CustomTimerController ctController = new CustomTimerController(tRequestModel, tResponseModel);
    PresetTimerController ptController = new PresetTimerController(tRequestModel, tResponseModel);
    TimerPresenter tPresenter = new TimerPresenter(tResponseModel);

    public TimerPanel(CardLayout card, JPanel parentPanel) {
        progressBar.setMinimum(0);
        progressBar.setValue(0);

        timerText.setFont(new Font("Verdana", Font.PLAIN, 48));

        timer = new Timer(100, new UITimerListener(timerText, tPresenter, progressBar, breakMenuButton, customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField));

        this.card = card;
        this.parentPanel = parentPanel;

        this.add(mainPanel);

        addListeners();
    }

    public static int convertTimeToInt(String time) {
        String[] times = time.split(":", 3);
        int timeSeconds = Integer.parseInt(times[0])*3600 + Integer.parseInt(times[1])*60 + Integer.parseInt(times[2]);
        return timeSeconds;
    }

    public void addListeners() {
        startTimerButton.addActionListener(new StartTimerButtonListener(ptController, ctController, timer, customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField));
        endTimerButton.addActionListener(new EndTimerButtonListener(ptController, ctController, timer, timerText, breakMenuButton, customTimerConfirmButton, presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField));
        presetShortButton.addActionListener(new PresetShortButtonListener(ptController, ctController, timerText, progressBar));
        presetMediumButton.addActionListener(new PresetMediumButtonListener(ptController, ctController, timerText, progressBar));
//        presetLongButton.addActionListener(new PresetLongButtonListener(ptController, ctController, timerText, progressBar));
        customTimerConfirmButton.addActionListener(new CustomTimerConfirmButtonListener(ctController, customTimerTextField, timerText, progressBar, errorLabel));
        customTimerTextField.addKeyListener(new CustomTimerTextFieldKeyListener(customTimerTextField));
        customTimerTextField.addCaretListener(new CustomTimerTextFieldCaretListener(customTimerTextField));
        customTimerTextField.addFocusListener(new CustomTimerTextFieldFocusListener(customTimerTextField));
        breakMenuButton.addActionListener(new BreakMenuButtonListener(card, parentPanel));
    }
}

