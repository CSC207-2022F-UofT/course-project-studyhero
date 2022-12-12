package shopmenu.usecases.buy_menu;

public class BuyMenuButtonInteractor {
    BuyMenuGoldUpdater buyMenuGoldUpdater;
    BuyMenuPlayerInvUpdater buyMenuPlayerInvUpdater;


    /**
     * Creates a BuyMenuButtonInteractor object that is used for the BuyMenuButtonController.
     * It updates the user's gold and inventory when purchasing an item.
     *
     * @param buyMenuShopInvInitializer     BuyMenuShopInvInitializer that shows the items in the ShopInventoryFile.
     *
     * @param index                         An integer that is used for determining which index of the Inventory
     *                                      object is added to the player inventory.
     */
    public BuyMenuButtonInteractor(BuyMenuShopInvInitializer buyMenuShopInvInitializer,
                                   int index) {
        this.buyMenuGoldUpdater = new BuyMenuGoldUpdater();
        this.buyMenuPlayerInvUpdater = new BuyMenuPlayerInvUpdater();

        buyMenuPlayerInvUpdater.addItemPlayerInv(
                buyMenuShopInvInitializer.getShopInventory().get(index)
        );

        buyMenuGoldUpdater.updateGoldFromPurchase(
                buyMenuShopInvInitializer.getShopInventory().get(index).getGoldValue()
        );
    }
}
