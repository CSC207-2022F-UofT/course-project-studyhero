package screens;

import javax.swing.*;

public class panel {
    private static JPanel panel = new JPanel();

    public static JPanel getPanel(){
        return panel;
    }

    public static void addPanel(JPanel panelName, String index){
        panel.add(panelName, index);
    }
}
