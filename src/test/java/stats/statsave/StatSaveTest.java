package stats.statsave;

import org.junit.jupiter.api.*;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.save_game.StatSave;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class StatSaveTest {

    // method(s) to test: save

    static Map<String, Integer> validBaseStatsMap, validBaseFightStatsMap,
            validExtStatsMap, validExtFightStatsMap,
            validRedStatsMap, validRedFightStatsMap;

    ErrorOutputBoundary presenter = new ErrorPresenter();
    String filepath = "StatsSaveTest.csv";
    private static Map<String, Integer> generateMap(String[] header,
                                                    String[] stats){
        Map<String, Integer> statsMap = new HashMap<>();
        int i = 0;
        while (i < header.length){
            statsMap.put(header[i], Integer.valueOf(stats[i]));
            i++;
        }
        return statsMap;
    }
    @BeforeAll
    public static void setUp(){
        String[] validRegStatsHeader = {"gold", "damage", "level", "defence", "hp"};
        String[] validRegStatsStats = {"40", "5", "1", "0", "100"};
        validBaseStatsMap = generateMap(validRegStatsHeader,
                validRegStatsStats);

        String[] validRegFightStatsHeader = {"playerDamage", "playerDefence", "maxHealth",
                "playerHealth", "bossDamage", "bossHealth"};
        String[] validRegFightStatsStats = {"5", "0", "100", "100", "9", "12"};
        validBaseFightStatsMap = generateMap(
                validRegFightStatsHeader, validRegFightStatsStats);

        String[] validExtStatsHeader = {"gold", "damage", "level", "defence", "hp",
        "faith", "intelligence", "mana", "magic", "humanity", "shield"};
        String[] validExtStatsStats = {"40", "5", "1", "0", "100",
        "5", "90", "7", "0", "100", "9999"};
        validExtStatsMap = generateMap(
                validExtStatsHeader, validExtStatsStats);

        String[] validExtFightStatsHeader = {"playerDamage", "playerDefence", "maxHealth",
                "playerHealth", "bossDamage", "bossHealth", "bossMagic", "bossRegen"};
        String[] validExtFightStatsStats = {"5", "0", "100", "100", "9", "12","9","0"};
        validExtFightStatsMap = generateMap(
                validExtFightStatsHeader, validExtFightStatsStats);

        String[] validRedStatsHeader = {"gold", "level"};
        String[] validRedStatsStats = {"900", "5"};
        validRedStatsMap = generateMap(validRedStatsHeader,
                validRedStatsStats);

        String[] validRedFightStatsHeader = {"playerLevel", "bossLevel", "playerDamage"};
        String[] validRedFightStatsStats = {"5", "7", "100"};
        validRedFightStatsMap = generateMap(
                validRedFightStatsHeader, validRedFightStatsStats);
    }

    @AfterEach
    public void testSaved(){
        File stats = new File(filepath);
        Assertions.assertEquals(presenter.getError(), "");
        Assertions.assertTrue(stats.exists());
        stats.deleteOnExit();
    }

    @Test
    public void InitialStatsSave(){
        StatSave baseStats = new StatSave(validBaseStatsMap, presenter);
        baseStats.save(filepath);
    }

    @Test
    public void InitialFightStatsSave(){
        StatSave baseFightStats = new StatSave(validBaseFightStatsMap, presenter);
        baseFightStats.save(filepath);
    }

    @Test
    public void ExtendedStatsSave(){
        StatSave extStats = new StatSave(validExtStatsMap, presenter);
        extStats.save(filepath);
    }

    @Test
    public void ExtendedFightStatsSave(){
        StatSave extFightStats = new StatSave(validExtFightStatsMap, presenter);
        extFightStats.save(filepath);
    }

    @Test
    public void ReducedStatsSave(){
        StatSave redStats = new StatSave(validRedStatsMap, presenter);
        redStats.save(filepath);
    }
    @Test
    public void ReducedFightStatsSave(){
        StatSave redFightStats = new StatSave(validRedFightStatsMap, presenter);
        redFightStats.save(filepath);
    }


}
