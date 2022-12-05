package use_cases.stats_update_use_case;

public interface StatsUpdateInterface {
    void updateLevel();
    void updateGold(int changeBy);
    void updateHp(int changeBy);
    void updateTempDamage(int changeBy);
    void updateBaselineDamage(int changeBy);
    void updateDefence(int changeBy);
}
