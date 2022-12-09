package UI.screens.panels.breaks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyMenuScreenController implements ActionListener {
    CardLayout card;
    JPanel panel;

    public BuyMenuScreenController(CardLayout card, JPanel panel){
        this.card = card;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BuyMenuScreen buyMenuScreen = new BuyMenuScreen(card, panel);
        panel.add(buyMenuScreen, "Buy Menu");
        card.show(panel, "Buy Menu");
    }
}
