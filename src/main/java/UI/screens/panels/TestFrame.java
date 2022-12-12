package UI.screens.panels;

import javax.swing.*;
import java.awt.*;

public class TestFrame {
    public void main(String[] args){
        JFrame mainFrame = new JFrame("Frame");
        JPanel mainPanel = new JPanel();
        CardLayout card = new CardLayout();
        mainPanel.setLayout(card);
        mainFrame.add(mainPanel);
        //JPanel inventoryPanel = new InventoryPanel();
        JPanel startPanel = new StartScreen(card, mainPanel);

        mainPanel.add(startPanel, "Start");
        //mainPanel.add(inventoryPanel, "Inventory");
        card.show(mainPanel, "Start");

        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 500);
    }
}
