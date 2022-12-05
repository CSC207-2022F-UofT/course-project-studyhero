package entities;

import java.util.HashMap;
import java.util.Map;

/** An implementation of the Stats entity. 'Stats' stores all the stats relevant to the player and the boss,
 * which includes level, gold, hp, damage and defence of the user and the hp of the boss.
 */
public class StatsUser implements Stats {

    int level;
    int gold;
    int hp;
    int damage;
    int defence;
    static final int MAX=100;

    public StatsUser() {
        this.level = 1;
        this.gold = 0;
        this.hp = 0;
        this.damage = 0;
        this.defence = 0;
    }

    public StatsUser(Map<String, Integer> statsMap) {
        this.level = statsMap.get("level");
        this.gold = statsMap.get("gold");
        this.hp = statsMap.get("hp");
        this.damage = statsMap.get("damage");
        this.defence = statsMap.get("defence");
    }

    public Map<String, Integer> getUserStats() {
        return getStatsMapHelper();
    }

    private Map<String, Integer> getStatsMapHelper() {
        Map<String, Integer> statsMap = new HashMap<String, Integer>();
        statsMap.put("level", this.level);
        statsMap.put("gold", this.gold);
        statsMap.put("hp", this.hp);
        statsMap.put("damage", this.damage);
        statsMap.put("defence", this.defence);
        return statsMap;
    }

    public int updateLevel() {
        this.level += 1;
        return this.level;
    }

    public int changeGold(int by) {
        this.gold += changerValidator(this.gold, by);
        return this.gold;
    }

    public int changeHP(int by) {
        if((this.hp+by)>StatsUser.MAX) {
            this.hp = StatsUser.MAX;
        } else {
            this.hp = changerValidator(this.hp, by);
        } return this.hp;
    }

    public int changeDamage(int by) {
        this.damage += changerValidator(this.damage, by);
        return this.damage;
    }

    public int changeDefence(int by) {
        this.defence += changerValidator(this.defence, by);
        return this.defence;
    }

    private int changerValidator(int original, int by) {
        return Math.max(original + by, 0);
    }

}
