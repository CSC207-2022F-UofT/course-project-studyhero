package use_cases.buy_menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyMenuButtonController implements ActionListener {

    Frame frame;
    JLabel userGold;
    JList<String> list;
    JLabel selectedItem;
    JLabel cost;

    BuyMenuPlayerInvUpdater buyMenuPlayerInvUpdater;
    BuyMenuGoldUpdater buyMenuGoldUpdater;
    BuyMenuShopInvInitializer buyMenuShopInvInitializer;
    BuyMenuButtonInteractor buyMenuButtonInteractor;

    int index;
    CardLayout card;
    JPanel parentPanel;
    BuyMenuListController buyMenuListController;

    public BuyMenuButtonController(CardLayout card,
                                   JPanel parentPanel,
                                   JLabel userGold,
                                   JLabel cost,
                                   JLabel selectedItem,
                                   JList<String> list,
                                   BuyMenuListController buyMenuListController
                                   ) {

        this.card = card;
        this.parentPanel = parentPanel;
        this.userGold = userGold;

        this.cost = cost;
        this.selectedItem = selectedItem;
        this.list = list;

        this.buyMenuPlayerInvUpdater = new BuyMenuPlayerInvUpdater();
        this.buyMenuGoldUpdater = new BuyMenuGoldUpdater();
        this.buyMenuShopInvInitializer = new BuyMenuShopInvInitializer();
        this.buyMenuListController = buyMenuListController;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        parentPanel.repaint();
        index = buyMenuListController.getIndex();

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

            System.out.println(this.buyMenuGoldUpdater.getUserGold());
            // controller
            this.userGold.setText("Your Gold: " + this.buyMenuGoldUpdater.getUserGold());
            parentPanel.repaint();
        }
    }
}
