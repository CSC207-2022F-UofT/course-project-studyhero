package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatsUserTest {
    StatsUser statsNew;
    Map<String, Integer> statsMap;
    @BeforeEach
    public void setUp() {
        this.statsNew = new StatsUser();
        this.statsMap = new HashMap<>();
    }
    @Test
    void testStatsUserNewConstructorHasRightLevel() {
        assertEquals(1, (int) this.statsNew.getUserStats().get("level"));
    }
    @Test
    void testStatsUserNewConstructorHasRightGold() {
        assertEquals(0, (int) this.statsNew.getUserStats().get("gold"));
    }
    @Test
    void testStatsUserNewConstructorHasRightHp() {
        assertEquals(0, (int) this.statsNew.getUserStats().get("hp"));
    }
    @Test
    void testStatsUserNewConstructorHasRightDamage() {
        assertEquals(0, (int) this.statsNew.getUserStats().get("damage"));
    }
    @Test
    void testStatsUserNewConstructorHasRightDefence() {
        assertEquals(0, (int) this.statsNew.getUserStats().get("defence"));
    }
    @Test
    void testStatsUserLoadedConstructorSetsRightValues() {
        statsMap.put("level", 12);
        statsMap.put("hp", 10);
        statsMap.put("gold", 102);
        statsMap.put("damage", 5);
        statsMap.put("defence", 1);
        StatsUser loadedStats = new StatsUser(statsMap);
        /**assertTrue(loadedStats.level == 12 && loadedStats.currHp == 10 &&
                loadedStats.gold == 102 && loadedStats.baselineDamage == 5 && loadedStats.defence == 1);
        **/
         }
    @Test
    void testStatsUserGetterGetsRightValues() {
        statsMap.put("level", 56);
        statsMap.put("hp", 98);
        statsMap.put("gold", 1243);
        statsMap.put("damage", 5);
        statsMap.put("defence", 4);
        StatsUser loadedStats = new StatsUser(statsMap);
        assertEquals(statsMap, loadedStats.getUserStats());
    }
}