package use_cases.buy_menu;

import entities.StatsUser;
import inventorymenu.inventoryitem.InventoryItem;
import use_cases.save_game.StatSave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyMenuButtonController implements ActionListener {

    Frame frame;
    JLabel userGold;

    BuyMenuPlayerInvUpdater buyMenuPlayerInvUpdater;
    BuyMenuGoldUpdater buyMenuGoldUpdater;
    BuyMenuShopInvInitializer buyMenuShopInvInitializer;
    BuyMenuButtonInteractor buyMenuButtonInteractor;

    int index;
    CardLayout card;
    JPanel parentPanel;

    public BuyMenuButtonController(CardLayout card,
                                   JPanel parentPanel,
                                   int index,
                                   JLabel userGold) {
        this.card = card;
        this.parentPanel = parentPanel;
        this.index = index;
        this.userGold = userGold;

        this.buyMenuPlayerInvUpdater = new BuyMenuPlayerInvUpdater();
        this.buyMenuGoldUpdater = new BuyMenuGoldUpdater();
        this.buyMenuShopInvInitializer = new BuyMenuShopInvInitializer();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.buyMenuPlayerInvUpdater.getPlayerInventoryFile().inventoryFull()) {
            JOptionPane.showMessageDialog(frame,
                    "You do not have enough space in your inventory!",
                    "Purchase Error", JOptionPane.WARNING_MESSAGE);

        } else if (this.buyMenuGoldUpdater.getUserGold() < buyMenuShopInvInitializer.getShopInventory()
                .get(index).getGoldValue() ) {
            JOptionPane.showMessageDialog(frame,
                    "You do not have enough gold!",
                    "Purchase Error", JOptionPane.WARNING_MESSAGE);

        } else {
            buyMenuButtonInteractor = new BuyMenuButtonInteractor(buyMenuShopInvInitializer, index);

//            System.out.println(this.buyMenuGoldUpdater.getUserGold());
            // controller
//            this.userGold.setText("Your Gold: " + this.buyMenuGoldUpdater.getUserGold());
            parentPanel.repaint();
        }
    }
}
