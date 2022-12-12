package inventory.inventoryscreens;

import inventory.entities.InventoryItem;
import inventory.inventory_menu_use_case.equip_item_use_case.EquipItemDsGateway;
import inventory.inventory_menu_use_case.equip_item_use_case.EquipItemDsRequestModel;

import java.util.ArrayList;

public class FakeInventoryEquip implements EquipItemDsGateway {

    /**
     * @param inventoryList ,an arraylist that contains inventory information of type inventoryItem.
     */
    public FakeInventoryEquip(ArrayList<InventoryItem> inventoryList) {
        this.inventoryList = inventoryList;
    }

    private final ArrayList<InventoryItem> inventoryList;

    /**
     * Check if the item with the id exist in inventory
     * @param id of the item from inventory
     * @return true if the item exist in the inventory
     */
    @Override
    public boolean itemExist(int id) {
        return id <= inventoryList.size() && id > 0;
    }

    /**
     * Check if the item with the id is equipable
     * @param id of the item from inventory
     * @return true if the item is equipable
     */
    @Override
    public boolean itemEquipable(int id) {
        return inventoryList.get(id-1).getType().equals("Weapon") ||
                inventoryList.get(id-1).getType().equals("Shield");
    }

    /**
     * Equip Item from the inventory
     * @param id of the item wants to be equipped from inventory
     * @return the stats that needs to be added on player's stat.
     */
    @Override
    public int equipItem(int id) {
        int diff = 0;
        for(InventoryItem item : inventoryList){
            if(item.getType().equals(inventoryList.get(id - 1).getType())){
                diff -= item.getEffect();
                item.setEquipped(false);
            }
        }
        diff += inventoryList.get(id - 1).getEffect();
        inventoryList.get(id - 1).setEquipped(true);
        return diff;
    }

    /**
     * get the name of the equipped item
     * @param id of the item wants to be equipped from inventory
     * @return the name of the item that get equipped
     */
    @Override
    public EquipItemDsRequestModel getEquipName(int id) {
        if (itemExist(id)) {
            return new EquipItemDsRequestModel(inventoryList.get(id - 1).getName(),
                    inventoryList.get(id - 1).getType());
        }
        return null;
    }
}
