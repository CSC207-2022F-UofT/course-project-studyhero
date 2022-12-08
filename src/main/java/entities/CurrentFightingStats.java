package entities;

import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;
import use_cases.stats_update_use_case.StatsUpdateInteractor;

import java.util.HashMap;
import java.util.Map;

public class CurrentFightingStats implements FightingStats{

    StatsUpdateInteractor statsUpdateInteractor;

    int maxHP;

    int playerHP;

    int playerDamage;

    int playerDefence;

    int bossHP;

    int bossDamage;

    public CurrentFightingStats(){
        Map<String, Integer> statsMap = getFightStats();
        this.maxHP = statsMap.get("maxHealth");
        this.playerHP = statsMap.get("playerHealth");
        this.playerDamage = statsMap.get("playerDamage");
        this.playerDefence = statsMap.get("playerDefence");
        this.bossHP = statsMap.get("bossHealth");
        this.bossDamage = statsMap.get("bossDamage");
    }

    public void initializeFight(){
        Map<String, Integer> userStats = getPlayerStats();
        BossClass bossClass = new BossClass(userStats.get("level"));
        this.maxHP = userStats.get("hp");
        this.playerHP = userStats.get("hp");
        this.playerDamage = userStats.get("damage");
        this.playerDefence = userStats.get("defence");
        this.bossHP = bossClass.maxHp;
        this.bossDamage = bossClass.damage;
    }


    public Map<String, Integer> getPlayerStats(){
        ErrorPresenter presenter = new ErrorPresenter();
        ValidStats playerStats = new ValidStats("stats.csv", presenter);
        Map<String, Integer> statsMap = playerStats.load();
        StatsUser player = new StatsUser(statsMap);
        return player.getUserStats();
    }

    public Map<String, Integer> getFightStats(){
        ErrorPresenter presenter = new ErrorPresenter();
        ValidStats fightStats = new ValidStats("fightStats.csv", presenter);
        Map<String, Integer> statsMap = fightStats.load();
        return statsMap;
    }

    public Map<String, Integer> getUpdatedFightStats(){
        Map<String, Integer> updatedStatsMap = new HashMap<>();
        updatedStatsMap.put("maxHealth", this.maxHP);
        updatedStatsMap.put("playerHealth", this.maxHP);
        updatedStatsMap.put("playerDamage", this.playerDamage);
        updatedStatsMap.put("playerDefence", this.playerDefence);
        updatedStatsMap.put("bossHealth", this.bossHP);
        updatedStatsMap.put("bossDamage", this.bossDamage);
        return updatedStatsMap;
    }

    public void saveFightStats(){
        ErrorPresenter presenter = new ErrorPresenter();
        StatSave statSave = new StatSave(getUpdatedFightStats(), presenter);
        statSave.save("fightStats.csv");


    }


    public int getPlayerDamage() {
        return this.playerDamage;
    }

    public int getBossDamage() {
        return (this.bossDamage - this.playerDefence);
    }

    public void changePlayerHP(int by) {
        this.playerHP = Math.min((this.playerHP + by), this.maxHP);
    }

    public void changePlayerDamage(int by) {
        this.playerDamage = this.playerDamage + by;
    }

    public void changePlayerDefence(int by) {
        this.playerDefence = this.playerDefence + by;
    }

    public void changeBossHP(int by) {
        this.bossHP = this.bossHP + by;
    }

    public boolean winCondition(){
        return (this.playerHP <= 0 || this.bossHP <= 0);
    }
}