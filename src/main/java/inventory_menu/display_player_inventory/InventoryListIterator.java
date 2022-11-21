package inventory_menu.display_player_inventory;

import inventory_menu.inventory_item.InventoryItem;

public interface InventoryListIterator {
    InventoryItem getNext();
    boolean hasNext();
    void reset();
}
