package use_cases.buy_menu;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventoryitem.ShopInventoryFile;
import java.util.ArrayList;


public class BuyMenuShopInvInitializer {

    ArrayList<InventoryItemDsRequestModel> shopInventory;


    /**
     * The interactor BuyMenuShopInvInitializer that initializes shop inventory for the buy menu using the given
     * ShopInventoryFile and creating an ArrayList from the iterator.
     */
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

    /**
     * Returns the new shop inventory as an array list.
     *
     * @return the ArrayList of the shop inventory.
     */
    public ArrayList<InventoryItemDsRequestModel> getShopInventory() {
        return shopInventory;
    }


    /**
     * Returns the shop item display names to be used for the BuyMenuScreen selection.
     *
     * @return the ArrayList of strings of the display names of the shop inventory items.
     */
    public ArrayList<String> DisplayShopItems() {
        ArrayList<String> displayShopItems = new ArrayList<>();
        for (InventoryItemDsRequestModel inventoryItemDsRequestModel : shopInventory) {
            displayShopItems.add(inventoryItemDsRequestModel.getName());
        }
        return displayShopItems;
    }

}
