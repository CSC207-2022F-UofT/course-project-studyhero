package use_cases;

import org.junit.jupiter.api.*;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidStats;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;



public class ValidStatsTest {
    private ErrorOutputBoundary presenter;
    private static final String filepath = "statsTest.csv";
    private static File statsTestFile = new File(filepath);


    public File generateFile(String filepath, String header,
                             String stats){
        File statsFile = new File(filepath);
        try{
        PrintWriter out = new PrintWriter(statsFile);

        out.println(header);
        out.println(stats);
        out.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return statsFile;
    }

    public Map<String, Integer> makeMap(String header, String stats){
        Map<String, Integer> statsMap = new HashMap<>();
        String[] headerArray = header.split(", ");
        String[] statsArray = stats.split(", ");
        int i = 0;
        while (i < (headerArray.length)){
            statsMap.put(headerArray[i], Integer.valueOf(statsArray[i]));
            i++;
        }
        return statsMap;
    }

    @BeforeEach
    public void SetUp(){
        presenter = new ErrorPresenter();
    }

    @AfterEach
    public void clearFile(){
        statsTestFile.deleteOnExit();
    }

    @Test
        public void ValidPlayerStats(){
            String header = "gold, damage, level, defence, hp";
            String stats = "90, 51, 5, 10, 104";
            statsTestFile = generateFile(filepath, header, stats);
            ValidStats testFile = new ValidStats(filepath, presenter);

            Assertions.assertTrue(testFile.fileExists());
            Assertions.assertTrue(testFile.isPlayable());
            Assertions.assertTrue(testFile.isValid());
            Assertions.assertEquals(makeMap(header,stats), testFile.load());
    }

    @Test
    public void ValidTwoPlayerStats(){
        String header = "gold, damage";
        String stats = "90, 51";
        statsTestFile = generateFile(filepath, header, stats);
        ValidStats testFile = new ValidStats(filepath, presenter);

        Assertions.assertTrue(testFile.fileExists());
        Assertions.assertTrue(testFile.isPlayable());
        Assertions.assertTrue(testFile.isValid());
        Assertions.assertEquals(makeMap(header,stats), testFile.load());
    }

    @Test
    public void ValidTenPlayerStats(){
        String header = "gold, damage, level, defence, hp, " +
                "faith, purity, magic, physical, intelligence";
        String stats = "90, 51, 5, 10, 104, 10, 12345, 0, 70, 99";
        statsTestFile = generateFile(filepath, header, stats);
        ValidStats testFile = new ValidStats(filepath, presenter);

        Assertions.assertTrue(testFile.fileExists());
        Assertions.assertTrue(testFile.isPlayable());
        Assertions.assertTrue(testFile.isValid());
        Assertions.assertEquals(makeMap(header,stats), testFile.load());
    }

    @Test
    public void NonexistentFile() throws HeadlessException {
        if (statsTestFile.exists()){
            Assertions.assertTrue(statsTestFile.delete());
        }
        ValidStats testFile = new ValidStats(filepath, presenter);
        Assertions.assertFalse(testFile.isPlayable());
        Assertions.assertEquals("exist", testFile.checkError());
        Assertions.assertFalse(testFile.isValid());
        Assertions.assertEquals("Invalid " + filepath + " file.",
                presenter.getError());
        Assertions.assertEquals(new HashMap<>(), testFile.load());

        // generates a new file to be cleared
        String header = "";
        String stats = "";
        statsTestFile = generateFile(filepath, header, stats);
    }

    @Test
    public void StringsStats() throws HeadlessException{
        String header = "gold, damage, level, defence, hp";
        String stats = "a, 5, 1, 0, 100";
        statsTestFile = generateFile(filepath, header, stats);
        ValidStats testFile = new ValidStats(filepath, presenter);

        Assertions.assertTrue(testFile.fileExists());
        Assertions.assertFalse(testFile.isPlayable());
        Assertions.assertEquals("type", testFile.checkError());
        Assertions.assertEquals(new HashMap<>(), testFile.load());

    }

    @Test
    public void MoreStatsThanHeaders(){
        String header = "damage, level, defence, hp";
        String stats = "10, 5, 1, 0, 100";
        statsTestFile = generateFile(filepath, header, stats);
        ValidStats testFile = new ValidStats(filepath, presenter);

        Assertions.assertTrue(testFile.fileExists());
        Assertions.assertFalse(testFile.isPlayable());
        Assertions.assertEquals("invalid", testFile.checkError());
        Assertions.assertEquals(new HashMap<>(), testFile.load());

    }

    @Test
    public void MoreHeadersThanStats(){
        String header = "gold, damage, level, defence, hp";
        String stats = "10, 5, 1, 0";
        statsTestFile = generateFile(filepath, header, stats);
        ValidStats testFile = new ValidStats(filepath, presenter);

        Assertions.assertTrue(testFile.fileExists());
        Assertions.assertFalse(testFile.isPlayable());
        Assertions.assertEquals("invalid", testFile.checkError());
        Assertions.assertEquals(new HashMap<>(), testFile.load());
    }
    @Test
    public void EmptyFile(){
        String header = "";
        String stats = "";
        statsTestFile = generateFile(filepath, header, stats);
        ValidStats testFile = new ValidStats(filepath, presenter);

        Assertions.assertTrue(testFile.fileExists());
        Assertions.assertFalse(testFile.isPlayable());
        Assertions.assertEquals("attributes", testFile.checkError());
        Assertions.assertEquals(new HashMap<>(), testFile.load());
    }

    @Test
    public void SymbolStats(){
        String header = "gold, damage, level, defence, hp";
        String stats = "10, 5, 1, 0, c>p:?";
        statsTestFile = generateFile(filepath, header, stats);
        ValidStats testFile = new ValidStats(filepath, presenter);

        Assertions.assertTrue(testFile.fileExists());
        Assertions.assertFalse(testFile.isPlayable());
        Assertions.assertEquals("type", testFile.checkError());
        Assertions.assertEquals(new HashMap<>(), testFile.load());
    }

}
