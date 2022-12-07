package use_cases.change_stats;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeStatsController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;
    ErrorOutputBoundary presenter;

    public ChangeStatsController(CardLayout card, JPanel parent, ErrorOutputBoundary presenter){
        this.card = card;
        this.parentPanel = parent;
        this.presenter = presenter;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChangeStats updater = new ChangeStats(presenter);
        updater.updateLevel();
    }
}
