package inventorymenu.inventoryitem;
import inventorymenu.inventoryitem.inventory_menu_use_case.delete_item_use_case.DeleteItemDsGateway;
import inventorymenu.inventoryitem.inventory_menu_use_case.delete_item_use_case.DeleteItemDsRequestModel;
import inventorymenu.inventoryitem.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import inventorymenu.inventoryitem.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** The public class for adding inventory. AddItemToInventory stores all the
 * inventory information which includes item_type, item_name and item_effect.
 *
 */
public class InventoryList implements AddItemDsGateway, PlayerDisplayInventoryDsGateway, DeleteItemDsGateway{

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();

    /**
     * It read a file that stores the inventory information
     * @param csvPath file's path for storing the inventory information
     */
    public InventoryList(String csvPath){
        csvFile = new File(csvPath);

        headers.put("item_id", 0);
        headers.put("item_type", 1);
        headers.put("item_name", 2);
        headers.put("item_effect", 3);

        if(csvFile.length() == 0){
            save();
        }else{

            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(csvFile));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
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
                for(String s : col){
                    System.out.println(s);
                }

                int itemId = Integer.parseInt(col[headers.get("item_id")]);
                String itemType = String.valueOf(col[headers.get("item_type")]);
                String itemName = String.valueOf(col[headers.get("item_name")]);
                int itemEffect = Integer.parseInt(col[headers.get("item_effect")]);
                InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(itemId, itemType, itemName,itemEffect);
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
     * @param item is the item which need to be added to the inventory
     */
   @Override
    public void save(InventoryItem item){
       if(!inventoryFull()){
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
        int id = CheckLatestInventoryItemId();

        return new InventoryItemDsRequestModel(id,
                item.getType(),
                item.getName(),
                item.getEffect());
    }


    /**
     * Check how many InventoryItem are in the inventory
     * @return the number of items in the inventory
     */
    @Override
    public int CheckLatestInventoryItemId() {

        return inventoryList.size() + 1;
    }


    /**
     * Rewrite the inventory file with the added inventoryItem
     */
    private void save(){
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for(InventoryItemDsRequestModel item : inventoryList){
                String line = String.format("%s,%s,%s,%s",
                        item.getId(),
                        item.getType(),
                        item.getName(),
                        item.getEffect());
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
     * @return whether inventory's capacity is greater than 20
     */
    @Override
    public boolean inventoryFull() {
        return CheckLatestInventoryItemId() >=21;
    }

    /**
     * Create an iterator object on InventoryList for this file
     * @return an iterator object for this file object
     */
    @Override
    public PlayerDisplayInventoryDsRequestModel createIterator() {
        return new PlayerDisplayInventoryDsRequestModel(inventoryList);
    }

    /**
     * Check if the item is in the inventory
     * @return true if the item is in the inventory
     */
    @Override
    public boolean itemExist(int id) {
        return id <= inventoryList.size();
    }

    /**
     * Delete the item from inventory
     * @param id of the item wants to be removed from inventory
     */
    @Override
    public void deleteItem(int id) {
            inventoryList.remove(id);
            reassign();
            save();
    }

    /**
     * Reassign the ids for items in inventory
     */
    @Override
    public void reassign() {
        int newId = 1;
       for(InventoryItemDsRequestModel item : inventoryList){
           item.setId(newId);
           newId++;
       }
    }

    @Override
    public DeleteItemDsRequestModel getName(int id) {
        DeleteItemDsRequestModel name = new DeleteItemDsRequestModel(inventoryList.get(id + 1).getName());
        return name;
    }
}
