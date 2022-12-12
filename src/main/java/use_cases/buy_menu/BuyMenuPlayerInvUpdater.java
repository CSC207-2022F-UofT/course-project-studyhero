package use_cases.buy_menu;


import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventoryitem.InventoryItem;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventoryitem.PlayerInventoryFile;
import java.util.ArrayList;


public class BuyMenuPlayerInvUpdater {

    PlayerInventoryFile playerInventoryFile;
    ArrayList<InventoryItemDsRequestModel> playerInventory;

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
    public ArrayList<InventoryItemDsRequestModel> getPlayerInventory() {
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
