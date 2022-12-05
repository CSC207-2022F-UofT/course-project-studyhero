package UI.screens.panels.breaks;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class BuyMenuScreen extends JPanel implements ListSelectionListener {
    CardLayout card;
    JPanel parentPanel;

    static JList list;
    static JLabel selectedItem;
    static JLabel cost;

    public BuyMenuScreen(CardLayout card, JPanel parentPanel) {
        // Initialize Panels
        JPanel buyPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel shopPanel = new JPanel();
        JPanel topPanel = new JPanel();

        this.card = card;
        this.parentPanel = parentPanel;

        JLabel shopInv = new JLabel("Shop Inventory");

        JLabel title = new JLabel("Buy Menu");
        this.add(title);

        JButton backToBreak = new JButton("Back to Shop");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Shop Menu"));

        // Temporary: Add list
        String week[] = { "One", "Two", "Three", "Four" };
        list = new JList(week);

        list.clearSelection();
        list.addListSelectionListener(this);
        list.setMaximumSize(new Dimension(400, 300));

        selectedItem = new JLabel("Selected: ");
        cost = new JLabel("Cost: ");

        // Layouts
        BoxLayout mainBox = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(mainBox);

        BoxLayout userBox = new BoxLayout(userPanel, BoxLayout.Y_AXIS);
        userPanel.setLayout(userBox);

        BoxLayout shopBox = new BoxLayout(shopPanel, BoxLayout.Y_AXIS);
        shopPanel.setLayout(shopBox);

        BoxLayout buyBox = new BoxLayout(buyPanel, BoxLayout.X_AXIS);
        buyPanel.setLayout(buyBox);

        BoxLayout topBox = new BoxLayout(topPanel, BoxLayout.Y_AXIS);
        topPanel.setLayout(topBox);

        // Add to panels
        topPanel.add(title);

        shopPanel.add(shopInv);
        shopPanel.add(list);

        userPanel.add(selectedItem);
        userPanel.add(cost);

        buyPanel.add(shopPanel, BorderLayout.WEST);
        buyPanel.add(userPanel, BorderLayout.EAST);

        this.add(topPanel);
        this.add(buyPanel);
        this.add(backToBreak);

        this.add(backToBreak);
    }
    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue().toString());
        cost.setText("Cost: " + list.getSelectedIndex());
    }
}
