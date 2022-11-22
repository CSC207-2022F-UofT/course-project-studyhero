package InventoryMenu.InventoryItem;

public class DefencePotion extends Potion implements Defensive{
    /**
     *
     * @param name This is the name of the AttackPotion
     * @param type This is the type of the AttackPotion
     * @param effect This is the effect of the AttackPotion
     */
    public DefencePotion(String name, String type, int effect) {
        super(name, type, effect);
    }
    /**
     * Add attackBonus to player's attack (Incomplete)
     * @param defenceBonus
     */
    @Override
    public void enhanceDefence(int defenceBonus) {

    }
}
