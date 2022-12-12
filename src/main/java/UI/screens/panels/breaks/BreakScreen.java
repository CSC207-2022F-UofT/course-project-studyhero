package UI.screens.panels.breaks;

import use_cases.boss_fight.FightBossButtonController;
import use_cases.boss_fight.FightBossInteractor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
public class BreakScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    FightBossInteractor fightBossInteractor;

    public BreakScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;

        // Initialize Panels
        JPanel mainPanel = new JPanel();
        JPanel tabsPanel = new JPanel();

        CardLayout newCard = new CardLayout();
        JPanel newPanel = new JPanel();
        newPanel.setLayout(newCard);


        JLabel title = new JLabel("Time to take a break...");

        JButton studyMenu = new JButton("To Another Adventure!");
        studyMenu.addActionListener(e -> card.show(parentPanel, "Timer"));

        JButton shopMenu = new JButton("Shop");
        shopMenu.addActionListener(e -> card.show(parentPanel, "Shop Menu"));

        JButton statsMenu = new JButton("Stats");
        statsMenu.addActionListener(e ->
            {StatsDisplayScreen statsDisplayScreen = new StatsDisplayScreen(newCard, newPanel);
                newPanel.add(statsDisplayScreen, "Stats");
                newCard.show(newPanel, "Stats");});

        // ===== FightBoss Screen =====
        JButton fightBoss = new JButton("Fight Boss");
        FightBossButtonController fightBossButtonController =
                new FightBossButtonController(card, parentPanel);
        fightBoss.addActionListener(fightBossButtonController);
        FightBossButtonController fightBossButtonController = new FightBossButtonController(this.card, this.parentPanel);
        fightBoss.addActionListener(fightBossButtonController);

        JButton settings = new JButton("Settings");
        settings.addActionListener(e -> card.show(parentPanel, "Break Settings"));

        // ===== Initialise An Inventory Menu =====
        JButton inventoryMenu = new JButton("Inventory Menu");
        inventoryMenu.addActionListener(e ->
            {InventoryPanel inventoryPanel = new InventoryPanel(newCard, newPanel);
            newPanel.add(inventoryPanel, "Inventory");
            newCard.show(newPanel, "Inventory");});

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
        tabsPanel.add(inventoryMenu);

        mainPanel.add(tabsPanel, Component.CENTER_ALIGNMENT);

        newPanel.add(mainPanel,"Main Break");

        newCard.show(newPanel,"Main Break");
        this.add(newPanel);
        //this.add(mainPanel);
    }
}