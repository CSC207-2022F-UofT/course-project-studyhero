package inventory_menu.add_item;

import inventory_menu.inventory_item.InventoryItem;

public interface AddItemDsGateway {
     boolean inventoryFull();

     void save(InventoryItem requestModel);
}
