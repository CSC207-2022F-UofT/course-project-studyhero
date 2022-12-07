package UI.screens.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;
import Timer.timer_use_cases.TimerResponseModel;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class TimerPanel extends JPanel implements ActionListener {
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
    private JButton goToBreakMenuButton;

    private Timer timer;

    CardLayout card;
    JPanel parentPanel;

    TimerRequestModel tRequestModel = new TimerRequestModel();
    TimerResponseModel tResponseModel = new TimerResponseModel();
    CustomTimerController ctController = new CustomTimerController(tRequestModel, tResponseModel);
    PresetTimerController ptController = new PresetTimerController(tRequestModel, tResponseModel);
    TimerPresenter tPresenter = new TimerPresenter(tResponseModel);

    public TimerPanel(CardLayout card, JPanel parentPanel) {
        startTimerButton.addActionListener(this);
        endTimerButton.addActionListener(this);
        presetShortButton.addActionListener(this);
        presetMediumButton.addActionListener(this);
        presetLongButton.addActionListener(this);
        customTimerConfirmButton.addActionListener(this);
        customTimerTextField.addActionListener(this);
        goToBreakMenuButton.addActionListener(e -> card.show(parentPanel, "Break"));


        CaretListener cListener = new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int textLength = customTimerTextField.getText().length();
                if (textLength == 2 || textLength == 5) {
                    SwingUtilities.invokeLater (new Runnable() {
                        public void run() {
                            customTimerTextField.setText(customTimerTextField.getText() + ":");
                        }
                    });
                }
                if (textLength >= 9) {
                    SwingUtilities.invokeLater (new Runnable() {
                        public void run() {
                            customTimerTextField.setText(customTimerTextField.getText().substring(0, 8));
                        }
                    });
                }
            }
        };
        customTimerTextField.addCaretListener(cListener);

        customTimerTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    customTimerTextField.setEditable(true);
                } else {
                    customTimerTextField.setEditable(false);
                }
            }
        });

        progressBar.setMinimum(0);
        progressBar.setValue(0);

        timerText.setFont(new Font("Verdana", Font.PLAIN, 48));

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerText.setText(tPresenter.updateTimer());
                progressBar.setValue(progressBar.getMaximum() - convertTimeToInt(tPresenter.updateTimer()));
            }
        });

        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startTimerButton) {
            if (ctController.getCustomTime().equals("-1")) {
                ptController.startTimer();
            } else {
                ctController.startTimer();
            }
            timer.start();
        }
        if (e.getSource() == endTimerButton) {
            if (ctController.getCustomTime().equals("-1")) {
                ptController.endTimer();
            }
            else {
                ctController.endTimer();
            }
            timer.stop();
            timerText.setText("00:00:00");
        }
        int totalTime = 0;
        if (e.getSource() == customTimerConfirmButton) {
            String inputTime = customTimerTextField.getText();
            if (Pattern.matches("^[0-9]{2}:[0-5][0-9]:[0-5][0-9]$", inputTime)) {
                ctController.setCustomTime(inputTime);
                timerText.setText(inputTime);
                totalTime = convertTimeToInt(inputTime);
                progressBar.setMaximum(totalTime);
                errorLabel.setText("");
            }
            else {
                errorLabel.setForeground(Color.RED);
                errorLabel.setText("Invalid Time");
            }
        }
        if (e.getSource() == presetShortButton) {
            ctController.setCustomTime("-1");
            ptController.selectShortTime();
            String time = ptController.getShortTime();
            timerText.setText(time);
            totalTime = convertTimeToInt(time);
            progressBar.setMaximum(totalTime);

        }
        if (e.getSource() == presetMediumButton) {
            ctController.setCustomTime("-1");
            ptController.selectMediumTime();
            String time = ptController.getMediumTime();
            timerText.setText(time);
            totalTime = convertTimeToInt(time);
            progressBar.setMaximum(totalTime);

        }
        if (e.getSource() == presetLongButton) {
            ctController.setCustomTime("-1");
            ptController.selectLongTime();
            String time = ptController.getLongTime();
            timerText.setText(time);
            totalTime = convertTimeToInt(time);
            progressBar.setMaximum(totalTime);
        }
    }

    public static int convertTimeToInt(String time) {
        String[] times = time.split(":", 3);
        int timeSeconds = Integer.parseInt(times[0])*3600 + Integer.parseInt(times[1])*60 + Integer.parseInt(times[2]);
        return timeSeconds;
    }
}

