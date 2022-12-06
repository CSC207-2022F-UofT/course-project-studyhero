package UI.screens.panels.breaks;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BreakScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    public BreakScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;

        // Initialize Panels
        JPanel mainPanel = new JPanel();
        JPanel tabsPanel = new JPanel();


        JLabel title = new JLabel("Time to take a break...");

        JButton studyMenu = new JButton("To Another Adventure!");
        studyMenu.addActionListener(e -> card.show(parentPanel, "Timer"));

        JButton shopMenu = new JButton("Shop");
        shopMenu.addActionListener(e -> card.show(parentPanel, "Shop Menu"));

        JButton fightBoss = new JButton("Fight Boss");
        fightBoss.addActionListener(e -> card.show(parentPanel,"Fight Boss"));

        JButton settings = new JButton("Settings");
        settings.addActionListener(e -> card.show(parentPanel, "Break Settings"));

        // Add Layouts
        BoxLayout mainBox = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainBox);

        BoxLayout tabs = new BoxLayout(tabsPanel, BoxLayout.Y_AXIS);
        tabsPanel.setLayout(tabs);


        mainPanel.add(title, Component.CENTER_ALIGNMENT);
        tabsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.setBorder(new EmptyBorder(25, 25, 25, 25));

        tabsPanel.add(studyMenu);
        tabsPanel.add(shopMenu);
        tabsPanel.add(fightBoss);
        tabsPanel.add(settings);

        mainPanel.add(tabsPanel, Component.CENTER_ALIGNMENT);

        this.add(mainPanel);
    }
}