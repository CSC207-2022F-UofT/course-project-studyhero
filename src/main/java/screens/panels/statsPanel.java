package screens.panels;

import javax.swing.*;

public class statsPanel {
    public static JPanel statsPanel(){
        JPanel statsPanel = new JPanel();
        JLabel title = new JLabel("Stats Screen");

        statsPanel.add(title);
        return statsPanel;
    }

}
