package UI.screens.panels.breaks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellMenuScreenController implements ActionListener {
    CardLayout card;
    JPanel panel;

    public SellMenuScreenController(CardLayout card, JPanel panel){
        this.card = card;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SellMenuScreen sellMenuScreen = new SellMenuScreen(card, panel);
        panel.add(sellMenuScreen, "Sell Menu");
        card.show(panel, "Sell Menu");
    }
}
