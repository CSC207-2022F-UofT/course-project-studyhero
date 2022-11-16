package stats;

import entities.Stats;

public class StatsUser implements Stats {

    private int level;
    private int gold;
    private int hp;
    private int damage;
    private int defence;

    public StatsUser() {
        this.level = 1;
        this.gold = 0;
        this.hp = 0;
        this.damage = 0;
        this.defence = 0;
    }

    public int getLevel() { return this.level; }

    public int getGold() { return this.gold; }

    public int getHP() { return this.hp; }

    public int getDamage() { return this.damage; }

    public int getDefence() { return this.defence; }

    public int updateLevel() {
        this.level += 1;
        return this.level;
    }

    public int changeGold(int by) {
        this.gold += by;
        return this.gold;
    }

    public int changeHP(int by) {
        this.hp += by;
        return this.hp;
    }

    public int changeDamage(int by) {
        this.damage += by;
        return this.damage;
    }

    public int changeDefence(int by) {
        this.defence += by;
        return this.defence;
    }

}
