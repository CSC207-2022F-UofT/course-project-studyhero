package UI.screens.panels;

import stats.controllers.StatsDisplayController;
import stats.presenters.StatsDisplayPresenter;
import stats.presenters.StatsDisplayViewModel;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidStats;
import stats.usecases.stats_display_use_case.StatsDisplayInputBoundary;
import stats.usecases.stats_display_use_case.StatsDisplayInteractor;
import stats.usecases.stats_display_use_case.StatsDisplayOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StatsDisplayScreen extends JPanel {
    final StatsDisplayController statsDisplayController;
    CardLayout card;
    JPanel parentPanel;
    public StatsDisplayScreen(CardLayout card, JPanel parentPanel) {
        ValidStats validStats = new ValidStats("stats.csv", new ErrorPresenter());
        StatsDisplayInputBoundary statsDisplayInputBoundary = new StatsDisplayInteractor(validStats);
        StatsDisplayOutputBoundary statsDisplayOutputBoundary = new StatsDisplayPresenter();
        this.statsDisplayController = new StatsDisplayController(statsDisplayInputBoundary,
                statsDisplayOutputBoundary);
        this.card = card;
        this.parentPanel = parentPanel;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Your Stats");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        StatsDisplayViewModel viewModel = this.statsDisplayController.displayStats();
        Map<String, String> statsStringMap = viewModel.getStats();
        addStatsLabels(statsStringMap);

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Main Break"));
        this.add(backToBreak);
    }

    private void addStatsLabels(Map<String, String> statsStringMap) {
        for (Map.Entry<String, String> entry : statsStringMap.entrySet()) {
            JLabel stat = new JLabel(entry.getKey() + ": " + entry.getValue());
            this.add(stat);
        }
    }
}

