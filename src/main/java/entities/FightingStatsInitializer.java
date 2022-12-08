package entities;

import java.util.HashMap;
import java.util.Map;

public class FightingStatsInitializer {
    private final int maxHP;

    private final int playerHP;

    private final int playerDamage;

    private final int playerDefence;

    private final int bossHP;

    private final int bossDamage;

    public FightingStatsInitializer(){
        this.maxHP = 0;
        this.playerHP = 0;
        this.playerDamage = 0;
        this.playerDefence = 0;
        this.bossHP = 0;
        this.bossDamage = 0;
    }

    public Map<String, Integer> initialize(){
        Map<String, Integer> fightStatsMap = new HashMap<String, Integer>();
        fightStatsMap.put("maxHP", this.maxHP);
        fightStatsMap.put("playerHP", this.playerHP);
        fightStatsMap.put("playerDamage", this.playerDamage);
        fightStatsMap.put("playerDefence", this.playerDefence);
        fightStatsMap.put("bossHP", this.bossHP);
        fightStatsMap.put("bossDamage", this.bossDamage);
        return fightStatsMap;
    }

}
