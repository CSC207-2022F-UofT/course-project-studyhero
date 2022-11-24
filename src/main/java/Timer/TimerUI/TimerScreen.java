package Timer.TimerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Timer.TimerControllers.*;
import Timer.TimerPresenters.*;

public class TimerScreen implements ActionListener {
    private JButton startTimerButton;
    private JButton endTimerButton;
    private JButton presetShortButton;
    private JButton presetMediumButton;
    private JButton presetLongButton;
    private JButton customerTimerConfirmButton;
    private JTextField customTimerTextField;
    private JLabel timerText;

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

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimerPresenter tPresenter = new TimerPresenter();
                timerText.setText(tPresenter.displayTimer());
            }
        });

        timer.start();

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
            CustomTimerController cTController = new CustomTimerController();
            cTController.startTimer();
        }
        if (e.getSource() == endTimerButton) {
            int[] time = new int[]{0, 0, 0};
            //TimerEntity.endTimer();
            //TimerEntity.setTimer(time);
        }
        if (e.getSource() == customerTimerConfirmButton) {
            String inputTime = customTimerTextField.getText();
            CustomTimerController cTController = new CustomTimerController();
            cTController.getCustomTime(inputTime);
            timerText.setText(inputTime);

        }
        if (e.getSource() == presetShortButton) {

        }
        if (e.getSource() == presetMediumButton) {

        }
        if (e.getSource() == presetLongButton) {

        }
    }
}
