package UI.screens.panels.breaks;

import UI.screens.inventoryscreens.InventoryPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryPanelController implements ActionListener {
    CardLayout card;
    JPanel panel;

    public InventoryPanelController(CardLayout card, JPanel panel){
        this.card = card;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InventoryPanel inventoryPanel = new InventoryPanel(card, panel);
        panel.add(inventoryPanel, "Inventory");
        card.show(panel, "Inventory");
    }
}
