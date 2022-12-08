package entities;

import java.util.HashMap;
import java.util.Map;

public class FightingStatsInitializer {
    private final int maxHealth;

    private final int playerHealth;

    private final int playerDamage;

    private final int playerDefence;

    private final int bossHealth;

    private final int bossDamage;

    public FightingStatsInitializer(){
        this.maxHealth = 0;
        this.playerHealth= 0;
        this.playerDamage = 0;
        this.playerDefence = 0;
        this.bossHealth = 0;
        this.bossDamage = 0;
    }

    public Map<String, Integer> initialize(){
        Map<String, Integer> fightStatsMap = new HashMap<>();
        fightStatsMap.put("maxHealth", this.maxHealth);
        fightStatsMap.put("playerHealth", this.playerHealth);
        fightStatsMap.put("playerDamage", this.playerDamage);
        fightStatsMap.put("playerDefence", this.playerDefence);
        fightStatsMap.put("bossHealth", this.bossHealth);
        fightStatsMap.put("bossDamage", this.bossDamage);
        return fightStatsMap;
    }

}
