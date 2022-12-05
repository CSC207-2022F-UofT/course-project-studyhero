package inventorymenu.inventoryitem;

public class HealthPotion extends Potion implements Regenerative {
    /**
     * @param goldValue of the HealthPotion
     * @param name of the HealthPotion
     * @param effect of the HealthPotion
     */
    public HealthPotion(String name, int effect, int goldValue) {
        super("HealthPotion", name, effect, goldValue);
    }
    /**
     * Add healthBonus to player's health (Incomplete)
     * @param healthBonus
     */
    @Override
    public void restoreHealth(int healthBonus) {

    }
}
