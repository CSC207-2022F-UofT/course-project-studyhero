package use_cases.buy_menu;


import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventoryitem.InventoryItem;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventoryitem.PlayerInventoryFile;

import java.util.ArrayList;

/**
 * interactor
 */
public class BuyMenuPlayerInvUpdater {

    PlayerInventoryFile playerInventoryFile;
    ArrayList<InventoryItemDsRequestModel> playerInventory;

    public BuyMenuPlayerInvUpdater() {
        playerInventoryFile = new PlayerInventoryFile("PlayerInventory.csv");
        playerInventoryFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel playerIterator = playerInventoryFile.getInventoryListIterator();
        playerInventory = new ArrayList<>();
        while (playerIterator.hasNext()) {
            playerInventory.add(playerIterator.getNext());
        }
    }

    public ArrayList<InventoryItemDsRequestModel> getPlayerInventory() {
        return playerInventory;
    }

    public PlayerInventoryFile getPlayerInventoryFile() {
        return playerInventoryFile;
    }

    public void addItemPlayerInv(InventoryItemDsRequestModel itemAdded) {
        playerInventoryFile.save(new InventoryItem(
             itemAdded.getType(),
             itemAdded.getName(),
             itemAdded.getEffect(),
             itemAdded.getGoldValue(),
             itemAdded.checkIsEquipped()
        ));
    }

}
