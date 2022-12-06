package Timer;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Timer.timer_screen.TimerPanel;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel mainPanel = new JPanel();
        CardLayout card = new CardLayout();
        TimerPanel mPanel = new TimerPanel(card, mainPanel);
        mainPanel.add(mPanel, "Timer");
        mainPanel.setLayout(card);

        f.add(mainPanel);
        card.show(mainPanel, "Timer");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setTitle("StudyHero");
        f.setSize(800, 500);
        f.setVisible(true);
    }
}
