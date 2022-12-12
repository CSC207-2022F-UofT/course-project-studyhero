package inventory.entities;

public interface GenerateItemDsGateway {
    /**
     * Generate a new weapon item based on player's level
     */
    void addNewWeapon(int level);

    /**
     * Generate a new shield in the inventory based on player's level
     */
    void addNewShield(int level);

    /**
     * Generate a new attack potion in the inventory based on player's level
     */
    void addNewAttackPotion(int level);
    /**
     * Generate a new health potion in the inventory based on player's level
     */
    void addNewHealthPotion(int level);

    /**
     * Generate a new poison potion in the inventory based on player's level
     */
    void addPoisonPotion(int level);
}
