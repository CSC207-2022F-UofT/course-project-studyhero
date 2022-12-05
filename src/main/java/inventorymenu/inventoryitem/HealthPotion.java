package inventorymenu.inventoryitem;

public class HealthPotion extends Potion implements Regenerative {
    /**
     *
     * @param name of the AttackPotion
     * @param effect of the AttackPotion
     */
    public HealthPotion(String name, int effect) {
        super("HealthPotion", name, effect);
    }
    /**
     * Add healthBonus to player's health (Incomplete)
     * @param healthBonus
     */
    @Override
    public void restoreHealth(int healthBonus) {

    }
}
