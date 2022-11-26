package screens.panels;

import screens.mainCard;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;

import static screens.mainCard.*;
import static screens.mainPanel.switchPanel;

public class breakPanel {
    public static JPanel breakPanel(){
        JLabel text = new JLabel("Break Screen");
        JPanel breakPanel = new JPanel();
        JButton settingsButton = new JButton("Settings");
        CardLayout card = getCard();

        breakPanel.add(text);
        breakPanel.add(settingsButton);

        // fake button to go to start screen
        JButton start = new JButton("Start screen");
        //start.addActionListener(e -> switchPanel("Start"));
        breakPanel.add(start);

        return breakPanel;

    }
}
