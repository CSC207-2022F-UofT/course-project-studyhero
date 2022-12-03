package UI.screens.panels;

import entities.StatsUser;
import use_cases.errors.ErrorPresenter;
import use_cases.save_game.StatSave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class NextScreen extends JPanel implements ActionListener {

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

        JButton changeStatsButton = new JButton("Change Stats");
        changeStatsButton.addActionListener(e-> card.show(parentPanel, "Change Stats"));
        this.add(backButton);
        this.add(changeStatsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
