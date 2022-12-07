package inventory_menu.inventory_item;

/**
 *  This interface contains method for the inventory_item to implement that will increase Player's Attack
 */
public interface Aggresive {
    /**
     * Add attackBunus to player's stat
     * @param attackBonus is the bonus attack that will be added to player's stat
     */
    void enhanceAttack(int attackBonus);
}
