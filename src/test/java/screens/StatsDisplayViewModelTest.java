package screens;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatsDisplayViewModelTest {
    StatsDisplayViewModel viewmodel;


    @Test
    void testStatsDisplayViewModelHasRightAttributes() {
        Map<String, Integer> statsMap = new HashMap<String, Integer>();
        statsMap.put("level", 56);
        statsMap.put("hp", 98);
        statsMap.put("gold", 1243);
        statsMap.put("damage", 5);
        statsMap.put("defence", 4);
        this.viewmodel = new StatsDisplayViewModel(statsMap);
        assertTrue(viewmodel.level == 56 && viewmodel.gold == 1243 && viewmodel.hp == 98 && viewmodel.damage == 5
        && viewmodel.defence == 4);
    }

}