package InventoryMenu.InventoryItem;
import InventoryMenu.inventory_menu_use_case.add_item.AddItemDsGateway;
import InventoryMenu.inventory_menu_use_case.display_player_inventory.PlayerDisplayInventoryDsGateway;
import InventoryMenu.inventory_menu_use_case.display_player_inventory.PlayerDisplayInventoryDsRequestModel;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** The public class for adding inventory. AddItemToInventory stores all the
 * inventory information which includes item_type, item_name and item_effect.
 *
 */
public class InventoryList implements AddItemDsGateway, PlayerDisplayInventoryDsGateway {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final ArrayList<InventoryItem> inventoryList = new ArrayList<>();

    /**
     * It read a file that stores the inventory information
     * @param csvPath file's path for storing the inventory information
     * @throws IOException file may not exist
     */
    public InventoryList(String csvPath){
        csvFile = new File(csvPath);

        headers.put("item_type", 0);
        headers.put("item_name", 1);
        headers.put("item_effect", 2);

        if(csvFile.length() == 0){
            save();
        }else{

            BufferedReader reader = null;
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
                    if (!((row = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String[] col = row.split(",");
                String itemType = String.valueOf(col[headers.get("item_type")]);
                String itemName = String.valueOf(col[headers.get("item_name")]);
                int itemEffect = Integer.valueOf(col[headers.get("item_effect")]);
                InventoryItem item = new InventoryItem(itemType,itemName,itemEffect);
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
     * @param requestModel the item which need to be added to the inventory
     */
   @Override
    public void save(InventoryItem requestModel){
       if(!inventoryFull()){
           inventoryList.add(requestModel);
       }
       this.save();
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

            for(InventoryItem item : inventoryList){
                String line = String.format("%s,%s,%s",
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
        return inventoryList.size() >=20;
    }

    /**
     * Create an iterator object on InventoryList for this file
     * @return an iterator object for this file object
     */
    @Override
    public PlayerDisplayInventoryDsRequestModel createIterator() {
        return new PlayerDisplayInventoryDsRequestModel(this, inventoryList);
    }
}