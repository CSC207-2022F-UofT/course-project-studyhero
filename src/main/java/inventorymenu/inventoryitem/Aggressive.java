package inventorymenu.inventoryitem;

/**
 *  This interface contains method for the InventoryItem to implement that will increase Player's Attack
 */
public interface Aggressive {
    /**
     * Add attackBonus to a unit's stat
     * @param attackBonus is the bonus attack that will be added to a unit's stat
     */
    void enhanceAttack(int attackBonus);
}
