package UI.screens.panels;

import use_cases.errors.ErrorPresenter;

import javax.swing.*;
import java.awt.*;

public class NextScreen extends JPanel{

    CardLayout card;
    JPanel parentPanel;
    ErrorPresenter presenter;

    public NextScreen(CardLayout card, JPanel parentPanel, ErrorPresenter presenter){
        this.card = card;
        this.parentPanel = parentPanel;
        this.presenter = presenter;

        JLabel title = new JLabel("Next Screen");
        this.add(title);
        JButton backButton = new JButton("Go Back");
        backButton.addActionListener(e -> card.show(parentPanel, "New"));

        JButton settings = new JButton("Settings");
        settings.addActionListener(e -> card.show(parentPanel, "Settings"));

        JButton changeStatsButton = new JButton("Change Stats");
        changeStatsButton.addActionListener(e-> card.show(parentPanel, "Change Stats"));
        this.add(backButton);
        this.add(changeStatsButton);
        this.add(settings);
    }

}
