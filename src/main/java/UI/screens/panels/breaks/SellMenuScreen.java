package UI.screens.panels.breaks;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SellMenuScreen extends JPanel implements ListSelectionListener {
    CardLayout card;
    JPanel parentPanel;

    static JList list;
    static JLabel selectedItem;
    static JLabel cost;

    public SellMenuScreen(CardLayout card, JPanel parentPanel) {
        // Initialize Panels
        JPanel sellPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel shopPanel = new JPanel();
        JPanel topPanel = new JPanel();

        this.card = card;
        this.parentPanel = parentPanel;

        JLabel title = new JLabel("Sell Menu");

        JLabel userInv = new JLabel("User Inventory");

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Shop Menu"));

        // Temporary: Add list
        String week[] = { "One", "Two", "Three", "Four" };
        list = new JList(week);

        list.clearSelection();
        list.addListSelectionListener(this);
        list.setMaximumSize(new Dimension(400, 300));

        selectedItem = new JLabel("Selected: ");
        cost = new JLabel("Sell Cost: ");

        // Layouts
        BoxLayout mainBox = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(mainBox);

        BoxLayout userBox = new BoxLayout(userPanel, BoxLayout.Y_AXIS);
        userPanel.setLayout(userBox);

        BoxLayout shopBox = new BoxLayout(shopPanel, BoxLayout.Y_AXIS);
        shopPanel.setLayout(shopBox);

        BoxLayout sellBox = new BoxLayout(sellPanel, BoxLayout.X_AXIS);
        sellPanel.setLayout(sellBox);

        BoxLayout topBox = new BoxLayout(topPanel, BoxLayout.Y_AXIS);
        topPanel.setLayout(topBox);

        // Add to panels
        topPanel.add(title);

        userPanel.add(userInv);
        userPanel.add(list);

        shopPanel.add(selectedItem);
        shopPanel.add(cost);

        sellPanel.add(userPanel, BorderLayout.WEST);
        sellPanel.add(shopPanel, BorderLayout.EAST);

        this.add(topPanel);
        this.add(sellPanel);
        this.add(backToBreak);
    }

    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue().toString());
        cost.setText("Sell Cost: " + list.getSelectedIndex());
    }
}
