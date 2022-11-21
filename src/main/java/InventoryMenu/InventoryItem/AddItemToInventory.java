package InventoryMenu.InventoryItem;
import InventoryMenu.AddItem.AddItemDsGateway;
import InventoryMenu.DisplayPlayerInventory.PlayerDisplayInventoryDsGateway;
import InventoryMenu.DisplayPlayerInventory.PlayerDisplayInventoryDsRequestModel;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** The public class for adding inventory. AddItemToInventory stores all the
 * inventory information which includes item_type, item_name and item_effect.
 *
 */
public class AddItemToInventory implements AddItemDsGateway{

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final ArrayList<InventoryItem> inventoryList = new ArrayList<>();

    public AddItemToInventory(String csvPath) throws IOException{
        csvFile = new File(csvPath);

        headers.put("item_type", 0);
        headers.put("item_name", 1);
        headers.put("item_effect", 2);

        if(csvFile.length() == 0){
            save();
        }else{

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String itemType = String.valueOf(col[headers.get("item_type")]);
                String itemName = String.valueOf(col[headers.get("item_name")]);
                int itemEffect = Integer.valueOf(col[headers.get("item_effect")]);
                InventoryItem item = new InventoryItem(itemType,itemName,itemEffect);
                inventoryList.add(item);
            }
            reader.close();
        }

    }


    /**
     * Add requestModel to storage.
     * @param requestModel the item information to save.
     */
   @Override
    public void save(InventoryItem requestModel){
       if(!inventoryFull()){
           inventoryList.add(requestModel);
       }
       this.save();
    }

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

}
