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
    /**
     * Constructor for the BossClass.
     * @param level: integer representing the user's level
     */
    public BossClass(int level, int currHp) {
        this.maxHp = 10 + 2*level;
        this.currHp = currHp;
        this.damage = -3 + 8*level + (new Random()).nextInt(8);
    }
    @Override
    public int getMaxHp() {
        return this.maxHp;
    }

    @Override
    public int getCurrentHp() {
        return this.currHp;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int updateCurrentHp(int changeBy) {
        this.currHp = Math.max(this.currHp + changeBy, 0);
        return currHp;
    }
}
