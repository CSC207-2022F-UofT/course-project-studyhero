package inventorymenu.inventoryitem;

/**
 *  This interface contains method for the InventoryItem to implement that will increase Player's Attack
 */
public interface Aggressive {
    /**
     * Add attackBonus to player's stat
     * @param attackBonus is the bonus attack that will be added to player's stat
     */
    void enhanceAttack(int attackBonus);
}
