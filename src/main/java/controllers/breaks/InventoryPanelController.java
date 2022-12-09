package controllers.breaks;

import UI.screens.inventoryscreens.InventoryPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InventoryPanelController implements ActionListener {
    private final CardLayout card;
    private final JPanel panel;

    /**
     * Creates a InventoryPanelController object that handles the
     * creation of a new InventoryPanel screen.
     *
     * @param card  layout of where the new screen will be stored
     * @param panel panel where the new screen will be stored
     */
    public InventoryPanelController(CardLayout card, JPanel panel){
        this.card = card;
        this.panel = panel;
    }

    /**
     * Upon the click of a button with event e, creates a new
     * InventoryPanel and adds/overwrites(if any) it into the
     * panel. Then uses the card to show the screen to the user.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        InventoryPanel inventoryPanel = new InventoryPanel(card, panel);
        panel.add(inventoryPanel, "Inventory");
        card.show(panel, "Inventory");
    }
}
