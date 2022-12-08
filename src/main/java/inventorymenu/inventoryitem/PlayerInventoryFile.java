package inventorymenu.inventoryitem;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** The public class for adding inventory. AddItemToInventory stores all the
 * inventory information which includes item_type, item_name and item_effect.
 *
 */
public class PlayerInventoryFile implements InventoryList, InitializePlayerInventoryGateway {

    private final File csvFile;
    private final String label = "Player Inventory";
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();


    /**
     * It read a file that stores the inventory information
     *
     * @param csvPath file's path for storing the inventory information
     */
    public PlayerInventoryFile(String csvPath) {
        csvFile = new File(csvPath);
        headers.put("item_id", 0);
        headers.put("item_type", 1);
        headers.put("item_name", 2);
        headers.put("item_effect", 3);
        headers.put("item_gold_value", 4);

        readInventoryList();
    }

    /**
     * Read the inventory File and record the information to inventory list
     */
    public void readInventoryList() {
        ErrorOutputBoundary error = new ErrorPresenter();
        ValidFileDsGateway validFile = new ValidPlayerInventory(csvFile.getName(), error);

        ShopInventoryFile.readInventory(validFile, csvFile, headers, inventoryList);
    }

    /**
     * Add new InventoryItem to the inventory
     *
     * @param item is the item which need to be added to the inventory
     */
    @Override
    public void save(InventoryItem item) {
        if (!inventoryFull()) {
            InventoryItemDsRequestModel requestModel = attachId(item);
            inventoryList.add(requestModel);
        }
        this.save();
    }

    /**
     * @param item The inventory item you want to add to the inventory
     * @return a AddItemDsRequestModel with id as the next available player's inventory slot
     */
    @Override
    public InventoryItemDsRequestModel attachId(InventoryItem item) {
        int id = CheckLatestInventoryItemId() + 1;

        return new InventoryItemDsRequestModel(id,
                item.getType(),
                item.getName(),
                item.getEffect(),
                item.getGoldValue());
    }


    /**
     * Check how many InventoryItem are in the inventory
     *
     * @return the number of items in the inventory
     */
    @Override
    public int CheckLatestInventoryItemId() {

        return inventoryList.size();
    }


    /**
     * Rewrite the inventory file with the added inventoryItem
     */
    public void save() {
        ShopInventoryFile.saveInventory(csvFile, label, headers, inventoryList);
    }

    /**
     * Return whether inventory is full
     *
     * @return whether inventory's capacity is greater than 20
     */
    @Override
    public boolean inventoryFull() {
        return CheckLatestInventoryItemId() >= 20;
    }

    /**
     * Create an iterator object on InventoryList for this file
     *
     * @return an iterator object for this file object
     */
    @Override
    public PlayerDisplayInventoryDsRequestModel getInventoryListIterator() {
        updateInventoryList();
        return new PlayerDisplayInventoryDsRequestModel(inventoryList);
    }

    /**
     * Updated the inventory list information
     */
    @Override
    public void updateInventoryList() {
        inventoryList.clear();
        readInventoryList();
    }


    /**
     * Check if the item is in the inventory
     *
     * @return true if the item is in the inventory
     */
    @Override
    public boolean itemExist(int id) {
        return id <= inventoryList.size() && id >= 1;
    }

    /**
     * Delete the item from inventory
     *
     * @param id of the item wants to be removed from inventory
     */
    @Override
    public void deleteItem(int id) {
        inventoryList.remove(id - 1);
        int newId = 1;
        for (InventoryItemDsRequestModel item : inventoryList) {
            item.setId(newId);
            newId++;
        }
        save();
    }

    /**
     * get the item's name associated with inventory id
     *
     * @param id of the item wants to be removed from inventory
     * @return the name of the item that wants to be removed from inventory
     */
    @Override
    public DeleteItemDsRequestModel getName(int id) {
        if (itemExist(id)) {
            return new DeleteItemDsRequestModel(inventoryList.get(id - 1).getName());
        }
        return null;
    }

    /**
     * Clear the inventory file
     */
    @Override
    public void clearInventory() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.close();
            inventoryList.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialize player's inventory file
     */
    @Override
    public void initialize() {
        clearInventory();
        InventoryItem item1 = new InventoryItem(
                "Weapon",
                "Sword",
                13, 10);
        InventoryItem item2 = new InventoryItem(
                "AttackPotion",
                "StrengthPotion",
                5, 23);
        InventoryItem item3 = new InventoryItem(
                "Weapon",
                "HammerHammer",
                18, 43);
        InventoryItem item4 = new InventoryItem(
                "Shield",
                "BronzeShield",
                15, 20);
        save(item1);
        save(item2);
        save(item3);
        save(item4);
    }
}