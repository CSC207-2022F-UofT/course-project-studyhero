package screens.panels;

import screens.StatsDisplayController;
import screens.StatsDisplayViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StatsPanel extends JPanel {
    StatsDisplayController statsDisplayController;
    public StatsPanel(StatsDisplayController statsDisplayController) {
        this.statsDisplayController = statsDisplayController;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Your Stats");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        StatsDisplayViewModel viewModel = this.statsDisplayController.displayStats();
        Map<String, String> statsStringMap = viewModel.getStats();
        addStatsLabels(statsStringMap);
    }

    private void addStatsLabels(Map<String, String> statsStringMap) {
        for (Map.Entry<String, String> entry : statsStringMap.entrySet()) {
            JLabel stat = new JLabel(entry.getKey() + ": " + entry.getValue());
            this.add(stat);
        }
    }
}
