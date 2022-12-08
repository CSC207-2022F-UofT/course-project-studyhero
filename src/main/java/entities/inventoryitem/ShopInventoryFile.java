package entities.inventoryitem;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemDsRequestModel;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.ShopDisplayInventoryDsGateway;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidShopInventory;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** The public class for adding inventory. AddItemToInventory stores all the
 * inventory information which includes item_type, item_name and item_effect.
 *
 */
public class ShopInventoryFile implements InventoryList, InitializeShopInventoryGateway,
        ShopDisplayInventoryDsGateway, GenerateItemDsGateway{

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();


    /**
     * It read a file that stores the inventory information
     *
     * @param csvPath file's path for storing the inventory information
     */
    public ShopInventoryFile(String csvPath) {
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
        ValidFileDsGateway validFile = new ValidShopInventory(csvFile.getName(), error);

        readInventory(validFile);
    }

    private void readInventory(ValidFileDsGateway validFile) {
        if (validFile.fileExists() && validFile.isPlayable()) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(csvFile));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                reader.readLine();
                reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String row;
            while (true) {
                try {
                    if (((row = reader.readLine()) == null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] col = row.split(",");
                int itemId = Integer.parseInt(col[headers.get("item_id")]);
                String itemType = String.valueOf(col[headers.get("item_type")]);
                String itemName = String.valueOf(col[headers.get("item_name")]);
                int itemEffect = Integer.parseInt(col[headers.get("item_effect")]);
                int itemGoldValue = Integer.parseInt(col[headers.get("item_gold_value")]);
                InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(itemId,
                        itemType, itemName, itemEffect, itemGoldValue,  false);
                inventoryList.add(item);
            }
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
                item.getGoldValue(), false);
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
    private void save(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            String label = "Player Inventory";
            writer.write(label);
            writer.newLine();
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (InventoryItemDsRequestModel item : inventoryList) {
                String line = String.format("%s,%s,%s,%s,%s",
                        item.getId(),
                        item.getType(),
                        item.getName(),
                        item.getEffect(),
                        item.getGoldValue());
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    public void addNewWeapon(int level) {
        int weaponAttack = level * 8 - 3;
        int goldValue = level * 9 - 3;
        InventoryItem item = new Weapon("Sword", weaponAttack, goldValue);
        save(item);
    }

    @Override
    public void addNewShield(int level) {
        int shieldDefence = level * 8 - 3;
        int goldValue = level * 9 - 3;
        InventoryItem item = new Shield("Bronze Shield", shieldDefence, goldValue);
        save(item);
    }

    @Override
    public void addNewAttackPotion(int level) {
        int effect = 15;
        int goldValue = level * 5 - 3;
        InventoryItem item = new AttackPotion("Strength Potion", effect, goldValue);
        save(item);
    }

    @Override
    public void addNewHealthPotion(int level) {
        int effect = 15;
        int goldValue = level * 5 - 3;
        InventoryItem item = new HealthPotion("Health Potion", effect, goldValue);
        save(item);
    }

    @Override
    public void addPoisonPotion(int level) {
        int effect = 5;
        int goldValue = level * 5 - 3;
        InventoryItem item = new PoisonPotion("Poison Potion", effect, goldValue);
        save(item);
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
    public DeleteItemDsRequestModel getDeletionName(int id) {
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
                3, 6, false);
        InventoryItem item2 = new InventoryItem(
                "AttackPotion",
                "StrengthPotion",
                4, 2, false);
        InventoryItem item3 = new InventoryItem(
                "Weapon",
                "HammerHammer",
                5, 8, false);
        InventoryItem item4 = new InventoryItem(
                "Shield",
                "BronzeShield",
                12, 23, false);
        save(item1);
        save(item2);
        save(item3);
        save(item4);
    }
}