package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerInteractor;
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
    public JLabel timerText;
    JProgressBar progressBar;
    public JButton presetShortButton;
    public JButton customTimerConfirmButton;
    public JButton presetLongButton;
    public JButton presetMediumButton;
    public JButton startTimerButton;
    public JButton endTimerButton;
    public JFormattedTextField customTimerTextField;
    public JLabel errorLabel;
    public JButton breakMenuButton;
    public Timer timer;
    /**
     * Layout that allows the user to switch between panels.
     */
    CardLayout card;
    /**
     * The panel that contains TimerPanel.
     */
    JPanel parentPanel;

    CustomTimerController customTimerController;
    PresetTimerController presetTimerController;
    TimerPresenter timerPresenter;

    /**
     * Constructor for TimerPanel. Sets up various elements on the panel and adds listeners to them using helper method
     * addListeners.
     * @param card layout that allows switching to different panels
     * @param parentPanel the panel that TimerPanel belongs to
     */
    public TimerPanel(CardLayout card, JPanel parentPanel) {
        TimerInteractor timerInteractor = new TimerInteractor();
        customTimerController = new CustomTimerController(timerInteractor);
        presetTimerController = new PresetTimerController(timerInteractor);
        timerPresenter = new TimerPresenter(timerInteractor.getTimerResponseModel());

        progressBar.setMinimum(0);
        progressBar.setValue(0);
        endTimerButton.setEnabled(false);

        timerText.setFont(new Font("Verdana", Font.PLAIN, 48));

        timer = new Timer(100, new UITimerListener(presetTimerController, customTimerController,
                timerText, timerPresenter, progressBar, breakMenuButton, customTimerConfirmButton, presetLongButton,
                presetMediumButton, presetShortButton, startTimerButton, customTimerTextField, endTimerButton, this));

        this.card = card;
        this.parentPanel = parentPanel;

        this.add(mainPanel);

        addListeners();
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

