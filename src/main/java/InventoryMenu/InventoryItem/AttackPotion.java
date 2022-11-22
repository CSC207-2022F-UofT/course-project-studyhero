package InventoryMenu.InventoryItem;


public class AttackPotion extends Potion implements Aggresive{


    /**
     *
     * @param name This is the name of the AttackPotion
     * @param type This is the type of the AttackPotion
     * @param effect This is the effect of the AttackPotion
     */
    public AttackPotion(String name, String type, int effect) {
        super(name, type, effect);
    }

    /**
     * Add attackBonus to player's attack (Incomplete)
     * @param attackBonus is the bonus attack that will be added to player's stat
     */
    @Override
    public void enhanceAttack(int attackBonus) {

    }
}
