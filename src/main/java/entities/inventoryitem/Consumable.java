package entities.inventoryitem;

/**
 *  This interface contains method for the inventory_item to implement that will consume the Consumable and add bonus to
 *  the player
 */
public interface Consumable{
    /**
     * Delete current Consumable object add the corresponding effect to player's stat
     */
    void consume();
}
