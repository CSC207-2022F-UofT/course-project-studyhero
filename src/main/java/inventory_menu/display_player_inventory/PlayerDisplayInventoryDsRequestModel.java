package inventory_menu.display_player_inventory;

import inventory_menu.inventory_item.InventoryItem;
import inventory_menu.inventory_item.InventoryList;

import java.util.ArrayList;

public class PlayerDisplayInventoryDsRequestModel implements InventoryListIterator {
    private int currentPosition = 0;

    public PlayerDisplayInventoryDsRequestModel(InventoryList file, ArrayList<InventoryItem> inventoryList) {
        this.file = file;
        this.inventoryList = inventoryList;
    }

    InventoryList file;
    private ArrayList<InventoryItem> inventoryList;

    @Override
    public InventoryItem getNext() {
        if(!hasNext()){
            return null;
        }

        InventoryItem item = new InventoryItem(inventoryList.get(currentPosition).getType(),
                inventoryList.get(currentPosition).getName(),
                inventoryList.get(currentPosition).getEffect());

        currentPosition += 1;
        return item;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < inventoryList.size();
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }

}
