package inventorymenu.inventory_item;

public class HealthPotion extends Potion implements Defensive{
    /**
     *
     * @param name This is the name of the AttackPotion
     * @param effect This is the effect of the AttackPotion
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
