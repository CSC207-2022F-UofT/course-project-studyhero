package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class CurrentFightStatsTest {
    CurrentFightingStats newCurr;

    Map<String, Integer> statsMap;

    @BeforeEach
    public void setup(){
        this.newCurr = new CurrentFightingStats("statstest.csv");
        this.statsMap = new HashMap<>();
    }

    @Test
    void testNewCurrentFightStatsValuesHP {
        assertEquals(10, (int) this.newCurr.getPlayerStats("statstest.csv").get("hp"));
    }

}
