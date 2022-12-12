package stats.entities;

import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;

import java.util.HashMap;
import java.util.Map;

/** An implementation of the FightingStats entity. FightingStats stores all the stats relevant to current combat,
 * which includes maxHP, playerHP, playerDamage, playerDefence, bossHP, and bossDamage.
 */
public class CurrentFightingStats implements FightingStats{

    int maxHP;

    int playerHP;

    int playerDamage;

    int playerDefence;

    int bossHP;

    int bossDamage;

    /**
     * Empty constructor for setting up the entity using the currently saved fightingStats.csv file
     */
    public CurrentFightingStats(){
        Map<String, Integer> statsMap = getFightStats();
        System.out.println(statsMap.toString());
        this.maxHP = statsMap.get("maxHealth");
        this.playerHP = statsMap.get("playerHealth");
        this.playerDamage = statsMap.get("playerDamage");
        this.playerDefence = statsMap.get("playerDefence");
        this.bossHP = statsMap.get("bossHealth");
        this.bossDamage = statsMap.get("bossDamage");
    }

    /**
     * Constructor for setting up the entity that takes in a string corresponding to a file path for the stats.csv
     * using a helper function
     * @param newFile: the path of the csv file
     */
    public CurrentFightingStats(String newFile){
        initializeFight(newFile);
    }
    public void initializeFight(String newFile){
        Map<String, Integer> userStats = getPlayerStats(newFile);
        BossClass bossClass = new BossClass(userStats.get("level"));
        this.maxHP = userStats.get("maxHp");
        this.playerHP = userStats.get("maxHp");
        this.playerDamage = userStats.get("baselineDamage");
        this.playerDefence = userStats.get("defence");
        this.bossHP = bossClass.maxHp;
        this.bossDamage = bossClass.damage;
        saveFightStats();
    }


    public Map<String, Integer> getPlayerStats(String newFile){
        ErrorPresenter presenter = new ErrorPresenter();
        ValidStats playerStats = new ValidStats(newFile, presenter);
        if (playerStats.isPlayable()) {
            Map<String, Integer> statsMap = playerStats.load();
            StatsUser player = new StatsUser(statsMap);
            return player.getUserStats();
        } else{
            return new HashMap<>();
        }
    }

    public Map<String, Integer> getFightStats(){
        ErrorPresenter presenter = new ErrorPresenter();
        ValidStats fightStats = new ValidStats("fightStats.csv", presenter);
        if (fightStats.isPlayable()) {
            return fightStats.load();
        } else{
            return new HashMap<>();
        }
    }

    /**
     * Takes the values currently in the instance variavles of the entity, and creates a mapping equivalent to those
     * values
     * @return mapping containing values of the entity
     */
    private Map<String, Integer> getUpdatedFightStats(){
        Map<String, Integer> updatedStatsMap = new HashMap<>();
        updatedStatsMap.put("maxHealth", this.maxHP);
        updatedStatsMap.put("playerHealth", this.playerHP);
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


    public int getPlayerHP(){ return this.playerHP; }

    public int getBossHP(){ return this.bossHP; }

    public int getPlayerDamage() { return this.playerDamage; }

    public int getBossDamage() { return this.bossDamage; }

    public void changePlayerHP(int by) { this.playerHP = this.playerHP + by; }

    public void changePlayerDamage(int by) { this.playerDamage = this.playerDamage + by; }

    public void changePlayerDefence(int by) { this.playerDefence = this.playerDefence + by; }

    public void changeBossHP(int by) { this.bossHP = this.bossHP + by; }

    public int winCondition(){
        if (this.playerHP <= 0){
            return 2;
        } else if (this.bossHP <= 0){
            return 1;
        } else{
            return 0; }
    }
}