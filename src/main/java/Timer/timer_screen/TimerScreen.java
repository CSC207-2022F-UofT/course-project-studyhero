package Timer.timer_screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;

public class TimerScreen implements ActionListener {
    private JButton startTimerButton;
    private JButton endTimerButton;
    private JButton presetShortButton;
    private JButton presetMediumButton;
    private JButton presetLongButton;
    private JButton customerTimerConfirmButton;
    private JTextField customTimerTextField;
    private JLabel timerText;

    TimerRequestModel tRequestModel = new TimerRequestModel();
    TimerResponseModel tResponseModel = new TimerResponseModel();
    CustomTimerController ctController = new CustomTimerController(tRequestModel, tResponseModel);
    PresetTimerController ptController = new PresetTimerController(tRequestModel, tResponseModel);
    TimerPresenter tPresenter = new TimerPresenter(tResponseModel);

    public void timerScreen() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        startTimerButton = new JButton("Start");
        startTimerButton.addActionListener(this);
        endTimerButton = new JButton("End");
        endTimerButton.addActionListener(this);
        presetShortButton = new JButton("Short");
        presetShortButton.addActionListener(this);
        presetMediumButton = new JButton("Medium");
        presetMediumButton.addActionListener(this);
        presetLongButton = new JButton("Long");
        presetLongButton.addActionListener(this);
        customerTimerConfirmButton = new JButton("Confirm");
        customerTimerConfirmButton.addActionListener(this);
        customTimerTextField = new JTextField(8);
        customTimerTextField.addActionListener(this);

        timerText = new JLabel("00:00:00");

        panel.add(startTimerButton);
        panel.add(endTimerButton);
        panel.add(presetShortButton);
        panel.add(presetMediumButton);
        panel.add(presetLongButton);
        panel.add(customerTimerConfirmButton);
        panel.add(customTimerTextField);
        panel.add(timerText);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startTimerButton) {
            if (tRequestModel.getInputTime().equals("-1")) {
                ptController.startTimer();
            }
            else {
                ctController.startTimer();
            }
            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerText.setText(tPresenter.updateTimer());
                }
            });
            timer.start();
        }
        if (e.getSource() == endTimerButton) {
            if (tRequestModel.getInputTime().equals("-1")) {
                ptController.endTimer();
            }
            else {
                ctController.endTimer();
            }
            timerText.setText("00:00:00");
        }
        if (e.getSource() == customerTimerConfirmButton) {
            String inputTime = customTimerTextField.getText();
            ctController.getCustomTime(inputTime);
            timerText.setText(inputTime);

        }
        if (e.getSource() == presetShortButton) {
            ptController.selectShortTime();
            timerText.setText(ptController.getShortTime());

        }
        if (e.getSource() == presetMediumButton) {
            ptController.selectMediumTime();
            timerText.setText(ptController.getMediumTime());

        }
        if (e.getSource() == presetLongButton) {
            ptController.selectLongTime();
            timerText.setText(ptController.getLongTime());
        }
    }
}
