package screens;

import java.util.Map;

public class StatsDisplayViewModel {
    Integer level;
    Integer gold;
    Integer hp;
    Integer damage;
    Integer defence;

    public StatsDisplayViewModel(Map<String, Integer> statsMap) {
        this.level = statsMap.get("level");
        this.gold = statsMap.get("gold");
        this.hp = statsMap.get("hp");
        this.damage = statsMap.get("damage");
        this.defence = statsMap.get("defence");
    }

}
