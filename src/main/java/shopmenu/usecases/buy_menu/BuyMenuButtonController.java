package shopmenu.usecases.buy_menu;

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

    /**
     * The BuyMenuButtonController that acts as the Action Listener for the BuyMenuScreen when the user selects
     * the "Buy Button" once they have selected an item.
     *
     * @param card                      The CardLayout from BuyMenuScreen for which the CardLayout is displayed on.
     *
     * @param parentPanel               The Panel from BuyMenuScreen for which the panel is displayed on.
     *
     * @param userGold                  A JLabel that is used to update the user's gold for the BuyMenuScreen after
     *                                  an item is purchased.
     *
     * @param cost                      A JLabel from BuyMenuScreen that is used for the buyMenuListController.
     *
     * @param selectedItem              A JLabel from BuyMenuScreen that is used for the buyMenuListController.
     *
     * @param list                      The JList from BuyMenuScreen that is used for the buyMenuListController.
     *
     * @param buyMenuListController     A BuyMenuListController that is called to get the index for the selected
     *                                  item that is purchased.
     */
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


    /**
     * The action listener for the buy item button that is used to purchase an item and adjusts the user's gold
     * and player inventory files accordingly. Will raise errors if the user has a full inventory or does not have
     * enough gold.
     *
     * @param e the event to be processed
     */
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

            this.userGold.setText("Your Gold: " + this.buyMenuGoldUpdater.getUserGold());
            parentPanel.repaint();
        }
    }
}
