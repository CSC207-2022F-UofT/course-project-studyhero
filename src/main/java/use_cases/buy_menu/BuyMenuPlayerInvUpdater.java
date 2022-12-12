package use_cases.buy_menu;


import inventory.inventory_item.entities.InventoryItem;
import inventory.inventory_item.entities.PlayerInventoryFile;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;

import java.util.ArrayList;


public class BuyMenuPlayerInvUpdater {

    PlayerInventoryFile playerInventoryFile;
    ArrayList<InventoryItem> playerInventory;

    /**
     * The BuyMenuPlayerInvUpdater interactor that takes in the playerInventoryFile from PlayerInventory.csv
     * and turns it into an ArrayList of inventory objects used for the BuyMenuScreen.
     */
    public BuyMenuPlayerInvUpdater() {
        playerInventoryFile = new PlayerInventoryFile("PlayerInventory.csv");
        playerInventoryFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel playerIterator = playerInventoryFile.getInventoryListIterator();
        playerInventory = new ArrayList<>();
        while (playerIterator.hasNext()) {
            playerInventory.add(playerIterator.getNext());
        }
    }

    /**
     * Gets the user's player inventory.
     *
     * @return an ArrayList of the user's player inventory.
     */
    public ArrayList<InventoryItem> getPlayerInventory() {
        return playerInventory;
    }

    /**
     * Gets the user's player inventory file that can be used to update the user's inventory.
     *
     * @return the PlayerInventoryFile
     */
    public PlayerInventoryFile getPlayerInventoryFile() {
        return playerInventoryFile;
    }

    /**
     * Adds an item to the user's player inventory.
     *
     * @param itemAdded     An InventoryItem that has the type, name, effect, gold value, and equipped parameters.
     */
    public void addItemPlayerInv(InventoryItem itemAdded) {
        playerInventoryFile.save(new InventoryItem(
             itemAdded.getId(),
             itemAdded.getType(),
             itemAdded.getName(),
             itemAdded.getEffect(),
             itemAdded.getGoldValue(),
             itemAdded.checkIsEquipped()
        ));
    }

}
