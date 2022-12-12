package shopmenu.usecases.buy_menu;

import inventory.entities.InventoryItem;
import inventory.entities.ShopInventoryFile;
import inventory.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;

import java.util.ArrayList;


public class BuyMenuShopInvInitializer {

    ArrayList<InventoryItem> shopInventory;


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
    public ArrayList<InventoryItem> getShopInventory() {
        return shopInventory;
    }


    /**
     * Returns the shop item display names to be used for the BuyMenuScreen selection.
     *
     * @return the ArrayList of strings of the display names of the shop inventory items.
     */
    public ArrayList<String> DisplayShopItems() {
        ArrayList<String> displayShopItems = new ArrayList<>();
        for (InventoryItem inventoryItemDsRequestModel : shopInventory) {
            displayShopItems.add(inventoryItemDsRequestModel.getName());
        }
        return displayShopItems;
    }

}
