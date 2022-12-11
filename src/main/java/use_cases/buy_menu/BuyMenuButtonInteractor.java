package use_cases.buy_menu;

import inventorymenu.inventoryitem.InventoryItem;

public class BuyMenuButtonInteractor {
    int index;
    BuyMenuGoldUpdater buyMenuGoldUpdater;
    BuyMenuPlayerInvUpdater buyMenuPlayerInvUpdater;
//    BuyMenuShopInvInitializer buyMenuShopInvInitializer;


    public BuyMenuButtonInteractor(BuyMenuShopInvInitializer buyMenuShopInvInitializer,
                                   int index) {
        this.buyMenuGoldUpdater = new BuyMenuGoldUpdater();
        this.buyMenuPlayerInvUpdater = new BuyMenuPlayerInvUpdater();

        buyMenuPlayerInvUpdater.addItemPlayerInv(
                buyMenuShopInvInitializer.getShopInventory().get(index)
        );

        System.out.println(buyMenuShopInvInitializer.getShopInventory().get(index).getGoldValue());

        buyMenuGoldUpdater.updateGoldFromPurchase(
                buyMenuShopInvInitializer.getShopInventory().get(index).getGoldValue()
        );
    }
}
