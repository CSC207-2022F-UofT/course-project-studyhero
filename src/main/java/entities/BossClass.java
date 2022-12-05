package entities;

import java.util.Random;

public class BossClass implements Boss{
    int currHp;
    int maxHp;
    int damage;

    /**
     * Constructor for the BossClass.
     * @param level: integer representing the user's level
     */
    public BossClass(int level) {
        this.maxHp = 10 + 2*level;
        this.currHp = this.maxHp;
        this.damage = -3 + 8*level + (new Random()).nextInt(8);
    }
    @Override
    public int getMaxHp() {
        return 0;
    }

    @Override
    public int getCurrentHp() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getDefence() {
        return 0;
    }

    @Override
    public int updateCurrentHp() {
        return 0;
    }
}
