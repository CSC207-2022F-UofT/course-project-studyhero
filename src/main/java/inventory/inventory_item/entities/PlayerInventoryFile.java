package inventory.inventory_item.entities;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemDsRequestModel;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import use_cases.inventory_menu_use_case.equip_item_use_case.EquipItemDsGateway;
import use_cases.inventory_menu_use_case.equip_item_use_case.EquipItemDsRequestModel;
import org.jetbrains.annotations.NotNull;
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
public class PlayerInventoryFile implements InventoryList, InitializePlayerInventoryGateway , PlayerDisplayInventoryDsGateway, EquipItemDsGateway {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final ArrayList<InventoryItem> inventoryList = new ArrayList<>();

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
        headers.put("item_is_equipped", 5);

        readInventoryList();
    }

    /**
     * Read the inventory File and record the information to inventory list
     */
    public void readInventoryList() {
        ErrorOutputBoundary error = new ErrorPresenter();
        ValidFileDsGateway validFile = new ValidPlayerInventory(csvFile.getName(), error);
        readInventory(validFile);
    }

    private void readInventory(@NotNull ValidFileDsGateway validFile) {
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
                boolean isEquipped = Boolean.parseBoolean(col[headers.get("item_is_equipped")]);
                InventoryItem item = new InventoryItem(itemId,
                        itemType, itemName, itemEffect, itemGoldValue,  isEquipped);
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
        updateInventoryList();
        if (!inventoryFull()) {
            inventoryList.add(item);
        }
        reassign();
        this.save();
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

                for (InventoryItem item : inventoryList) {
                    String line = String.format("%s,%s,%s,%s,%s,%s",
                            item.getId(),
                            item.getType(),
                            item.getName(),
                            item.getEffect(),
                            item.getGoldValue(),
                            item.checkIsEquipped());
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
        updateInventoryList();
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
     * @param id is the position of the item in player's inventory starting from 1
     * @return true if the item is in the inventory
     */
    @Override
    public boolean itemExist(int id) {
        return id <= inventoryList.size() && id >= 1;
    }

    /**
     * Check if the item is Equipable
     * @param id is the position of the item in player's inventory starting from 1
     * @return true if the inventory item is equipable
     */
    @Override
    public boolean itemEquipable(int id) {
        updateInventoryList();
        return inventoryList.get(id-1).getType().equals("Weapon") ||
                inventoryList.get(id-1).getType().equals("Shield");
    }

    /**
     *
     * @param id of the item wants to be equipped from inventory
     */
    @Override
    public int equipItem(int id) {
        int diff = 0;
        updateInventoryList();
        for(InventoryItem item : inventoryList){
            //Unequipped the item with the same type
            if(item.getType().equals(inventoryList.get(id - 1).getType())){
                diff -= item.getEffect();
                item.setEquipped(false);
            }
        }
        diff += inventoryList.get(id - 1).getEffect();
        inventoryList.get(id - 1).setEquipped(true);
        save();
        return diff;
    }

    /**
     *
     * @param id of the item that the player wants to be equipped from inventory
     * @return the name of the item that the player wants to be equipped from inventory
     */
    @Override
    public EquipItemDsRequestModel getEquipName(int id) {
        if (itemExist(id)) {
            return new EquipItemDsRequestModel(inventoryList.get(id - 1).getName(),
                    inventoryList.get(id - 1).getType());
        }
        return null;
    }


    /**
     * Delete the item from inventory
     *
     * @param id of the item wants to be removed from inventory
     */
    @Override
    public void deleteItem(int id) {
        inventoryList.remove(id - 1);
        reassign();
        save();
    }

    /**
     * reassign the id of the inventory
     */
    private void reassign(){
        int newId = 1;
        for (InventoryItem item : inventoryList) {
            item.setId(newId);
            newId++;
        }
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
        InventoryItem item1 = new Weapon(
                "Sword",
                13, 10);
        InventoryItem item2 = new AttackPotion(
                "StrengthPotion",
                5, 23);
        InventoryItem item3 = new Weapon(
                "Hammer",
                18, 43);
        InventoryItem item4 = new Shield(
                "BronzeShield",
                15, 20);
        save(item1);
        save(item2);
        save(item3);
        save(item4);
    }
}