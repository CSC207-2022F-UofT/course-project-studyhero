package Timer.TimerUI;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JLabel timerText;
    private JProgressBar progressBar1;
    private JButton a15MinutesButton;
    private JButton Confirm;
    private JButton a1HourButton;
    private JButton a30MinutesButton;
    private JButton startTimerButton;
    private JButton endTimerButton;
    private MaskFormatter timeFormatter;
    private JFormattedTextField formattedTextField1;


    public void TimerScreen() {
        try {
            timeFormatter = new MaskFormatter("##:##:##");
            timeFormatter.setPlaceholderCharacter('0');
            formattedTextField1 = new JFormattedTextField(timeFormatter);
        }
        catch (ParseException e)  {
            e.printStackTrace();
        }

        setContentPane(mainPanel);
        setTitle("StudyHero");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
