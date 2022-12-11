package use_cases.buy_menu;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventoryitem.ShopInventoryFile;

import java.util.ArrayList;

/**
 * interactor: initializes shop inventory for the buy menu
 */
public class BuyMenuShopInvInitializer {
    ArrayList<InventoryItemDsRequestModel> shopInventory;

    public BuyMenuShopInvInitializer() {
        ShopInventoryFile shopInventoryFile = new ShopInventoryFile("ShopInventory.csv");
        shopInventoryFile.initialize();
        shopInventoryFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel shopIterator = shopInventoryFile.getInventoryListIterator();
        shopInventory = new ArrayList<>();
        while (shopIterator.hasNext()) {
            shopInventory.add(shopIterator.getNext());
        }
    }

    public ArrayList<InventoryItemDsRequestModel> getShopInventory() {
        return shopInventory;
    }

    public ArrayList<String> DisplayShopItems() {
        ArrayList<String> displayShopItems = new ArrayList<>();
        for (InventoryItemDsRequestModel inventoryItemDsRequestModel : shopInventory) {
            displayShopItems.add(inventoryItemDsRequestModel.getName());
        }
        return displayShopItems;
    }

}
