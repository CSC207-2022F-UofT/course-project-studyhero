package entities;

import java.util.HashMap;
import java.util.Map;

/** An implementation of the Stats entity. Stats stores all the stats relevant to the player and the boss,
 * which includes level, gold, hp, damage and defence of the user and the hp of the boss.
 */
public class StatsUser implements Stats {

    int level;
    int gold;
    int currHp;
    int baselineDamage;
    int tempDamage;
    int defence;
    int maxHp;

    /**
     * Empty constructor for the user's stats. This initializes the stats for whenever a new game is started.
     */
    public StatsUser() {
        this.level = 1;
        this.gold = 100;
        this.currHp = 100;
        this.baselineDamage = 5;
        this.tempDamage = 5;
        this.defence = 0;
        this.maxHp = 100;
    }

    /**
     * Constructor for the user's stats that takes in a map from the string describing the type of stat to the value of
     * the stat, stored as an integer.
     *
     * @param statsMap map from the string describing the type of stat to the integer value of the stat. E.g.
     *                 statsMap.get("gold") is 12 if the user has 12 gold.
     */
    public StatsUser(Map<String, Integer> statsMap) {
        this.level = statsMap.get("level");
        this.gold = statsMap.get("gold");
        this.currHp = statsMap.get("hp");
        this.baselineDamage = statsMap.get("damage");
        this.tempDamage = statsMap.get("damage");
        this.defence = statsMap.get("defence");
        this.maxHp = calculateMaxHpFromLevel(this.level);
    }

    private int calculateMaxHpFromLevel(int level) {
        return 95 + 5*level;
    }

    public Map<String, Integer> getUserStats() {
        return getStatsMapHelper();
    }

    private Map<String, Integer> getStatsMapHelper() {
        Map<String, Integer> statsMap = new HashMap<>();
        statsMap.put("level", this.level);
        statsMap.put("gold", this.gold);
        statsMap.put("hp", this.currHp);
        statsMap.put("damage", this.baselineDamage);
        statsMap.put("defence", this.defence);
        return statsMap;
    }
    public int getTempDamage() {
        return this.tempDamage;
    }

    public int updateLevel() {
        this.level += 1;
        this.maxHp = calculateMaxHpFromLevel(this.level);
        this.baselineDamage = calculateBaselineDamageFromLevel(this.level);
        return this.level;
    }

    private int calculateBaselineDamageFromLevel(int level) {
        return -3 + 8*level;
    }

    public int updateGold(int by) {
        this.gold += changerValidator(this.gold, by);
        return this.gold;
    }

    public int updateCurrHp(int by) {
        if((this.currHp +by)>this.maxHp) {
            this.currHp = this.maxHp;
        } else {
            this.currHp = changerValidator(this.currHp, by);
        } return this.currHp;
    }

    public int updateBaselineDamage(int by) {
        this.baselineDamage += changerValidator(this.baselineDamage, by);
        return this.baselineDamage;
    }
    public int updateTempDamage(int by) {
        this.tempDamage += changerValidator(this.tempDamage, by);
        return this.tempDamage;
    }
    public int resetTempDamage() {
        this.tempDamage = this.baselineDamage;
        return this.tempDamage;
    }

    public int updateDefence(int by) {
        this.defence += changerValidator(this.defence, by);
        return this.defence;
    }

    private int changerValidator(int original, int by) {
        return Math.max(original + by, 0);
    }
}
