package UI.screens.timer_screen;

import javax.swing.*;

public class SetInteractabilityHelper {
    private JButton customTimerConfirmButton;
    private JButton presetLongButton;
    private JButton presetMediumButton;
    private JButton presetShortButton;
    private JButton startTimerButton;
    private JFormattedTextField customTimerTextField;
    private JButton endTimerButton;

    public SetInteractabilityHelper(JButton customTimerConfirmButton, JButton presetLongButton,
                                    JButton presetMediumButton, JButton presetShortButton, JButton startTimerButton,
                                    JFormattedTextField customTimerTextField, JButton endTimerButton) {
        this.customTimerConfirmButton = customTimerConfirmButton;
        this.presetLongButton = presetLongButton;
        this.presetMediumButton = presetMediumButton;
        this.presetShortButton = presetShortButton;
        this.startTimerButton = startTimerButton;
        this.customTimerTextField = customTimerTextField;
        this.endTimerButton = endTimerButton;
    }

    public void setInteractability(boolean clickable) {
        customTimerConfirmButton.setEnabled(clickable);
        presetLongButton.setEnabled(clickable);
        presetMediumButton.setEnabled(clickable);
        presetShortButton.setEnabled(clickable);
        startTimerButton.setEnabled(clickable);
        customTimerTextField.setEnabled(clickable);
        endTimerButton.setEnabled(!clickable);
    }
}
