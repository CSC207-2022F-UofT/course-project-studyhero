package use_cases.buy_menu;

public class BuyMenuButtonInteractor {
    BuyMenuGoldUpdater buyMenuGoldUpdater;
    BuyMenuPlayerInvUpdater buyMenuPlayerInvUpdater;


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
