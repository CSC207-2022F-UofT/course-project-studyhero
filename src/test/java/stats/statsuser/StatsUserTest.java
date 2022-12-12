package stats.statsuser;

import stats.entities.Stats;
import stats.entities.StatsUser;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatsUserTest {
    Stats stats1;
    Stats stats2;
    Map<String, Integer> statsMap1;
    Map<String, Integer> statsMap2;
    @Before
    public void setUp() {
        // Setting up map of initial stats to compare result of getUserStats() to
        statsMap1 = new HashMap<>();
        statsMap1.put("level", 1);
        statsMap1.put("gold", 0);
        statsMap1.put("maxHp", 100);
        statsMap1.put("baselineDamage", 5);
        statsMap1.put("defence", 0);

        // Using empty constructor of StatsUser
        stats1 = new StatsUser();

        // Using Map constructor of StatsUser
        statsMap2 = new HashMap<>();
        statsMap2.put("level", 10);
        statsMap2.put("gold", 120);
        statsMap2.put("maxHp", 100);
        statsMap2.put("baselineDamage", 13);
        statsMap2.put("defence", 2);
        stats2 = new StatsUser(statsMap2);
    }
    @Test
    void getUserStatsTest() {
        assertEquals(stats2.getUserStats(), statsMap2);
        assertEquals(stats1.getUserStats(), statsMap1);
    }
    @Test
    void updateLevelTest() {
        stats2.updateLevel();
        assertEquals(stats2.getUserStats().get("level"), 11);
    }
    @Test
    void updateGoldByPositiveNumberTest() {
        stats2.updateGold(23);
        assertEquals(stats2.getUserStats().get("gold"), 143);
    }
    @Test
    void updateGoldByValidNegativeNumberTest() {
        stats2.updateGold(-12);
        assertEquals(stats2.getUserStats().get("gold"), 108);
    }
    @Test
    void updateGoldByInvalidNegativeNumberTest() {
        stats1.updateGold(-23);
        assertEquals(stats1.getUserStats().get("gold"), 0);
    }
    @Test
    void updateBaselineDamageByPositiveNumberTest() {
        stats2.updateBaselineDamage(2);
        assertEquals(stats2.getUserStats().get("baselineDamage"), 15);
    }
    @Test
    void updateBaselineDamageByValidNegativeNumberTest() {
        stats2.updateBaselineDamage(-2);
        assertEquals(stats2.getUserStats().get("baselineDamage"), 11);
    }
    @Test
    void updateBaselineDamageByInvalidNegativeNumberTest() {
        stats1.updateBaselineDamage(-2);
        assertEquals(stats1.getUserStats().get("baselineDamage"), 0);
    }
    @Test
    void updateDefenceByPositiveNumberTest() {
        stats2.updateDefence(23);
        assertEquals(25, stats2.getUserStats().get("defence"));
    }
    @Test
    void updateDefenceByValidNegativeNumberTest() {
        stats2.updateDefence(-1);
        assertEquals(1, stats2.getUserStats().get("defence"));
    }
    @Test
    void updateDefenceByInvalidNegativeNumberTest() {
        stats2.updateDefence(-3);
        assertEquals(0, stats2.getUserStats().get("defence"));
    }
}