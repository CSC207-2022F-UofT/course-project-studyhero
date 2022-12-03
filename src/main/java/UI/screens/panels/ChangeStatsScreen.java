package UI.screens.panels;

import use_cases.change_stats.ChangeStatsController;
import use_cases.errors.ErrorPresenter;

import javax.swing.*;
import java.awt.*;

public class ChangeStatsScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;
    ErrorPresenter cGRM;
    public ChangeStatsScreen(CardLayout card, JPanel parent, ErrorPresenter cGRM){
        this.card = card;
        this.parentPanel = parent;
        this.cGRM = cGRM;

        JLabel title = new JLabel("Change Stats Here!");
        this.add(title);
        JButton updateLevel = new JButton("Update Level");
        ChangeStatsController changeStatsController = new ChangeStatsController(card, parent, cGRM);
        updateLevel.addActionListener(changeStatsController);

        this.add(updateLevel);


    }

}
