package use_cases;

import org.junit.jupiter.api.*;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidStats;
import use_cases.game_check.GameCheckInteractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GameCheckTest {

    private static final ErrorOutputBoundary presenter = new ErrorPresenter();
    private static final String statsPath = "statsTest.csv";
    private static final String playerInvPath = "PlayerInventoryTest.csv";
    private static final String fightStatsPath = "fightStatsTest.csv";
    private static File statsFile = new File(statsPath);
    private static File playerInvFile = new File(playerInvPath);
    private static File fightStatsFile = new File(fightStatsPath);

    public File generateStatsFile(String filepath, String header,
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
    public File generateInvFiles(String filepath, String header,
                                       String label, String[] items){
        File invFile = new File(filepath);
        try{
            PrintWriter out = new PrintWriter(invFile);

            out.println(header);
            out.println(label);
            for (String str : items){
                out.println(str);
            }
            out.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return invFile;
    }

    public void initialiseValidFiles(){
        String statsHeader = "gold, damage, level, defence, hp";
        String stats = "100, 5, 1, 0, 100";
        statsFile = generateStatsFile(statsPath, statsHeader, stats);

        String fightStatsHeader = "playerDamage, playerDefence, " +
                "maxHealth, playerHealth, bossDamage, bossHealth";
        String fightStats = "5, 0, 100, 100, 9, 12";
        fightStatsFile = generateStatsFile(fightStatsPath, fightStatsHeader,
                fightStats);

        String playerInvHeader = "Player Inventory";
        String playerInvLabel = "item_id,item_type,item_name,item_effect," +
                "item_gold_value,item_is_equipped";
        String[] playerInvItems =
                {"1,Weapon,Sword,13,10,false",
                        "2,AttackPotion,StrengthPotion,5,23,false",
                        "3,Weapon,Hammer,18,43,false",
                        "4,Shield,BronzeShield,15,20,false"};
        playerInvFile = generateInvFiles(playerInvPath, playerInvHeader,
                playerInvLabel, playerInvItems);

    }

    @BeforeEach
    public void setUp(){
        initialiseValidFiles();
    }

    @AfterEach
    public void deleteTestFiles(){
        statsFile.deleteOnExit();
        playerInvFile.deleteOnExit();
        fightStatsFile.deleteOnExit();
    }

    @Test
    public void ValidGameFiles(){
        ValidFileDsGateway validStats =
                new ValidStats(statsPath, presenter);
        ValidFileDsGateway validFightStats =
                new ValidStats(fightStatsPath, presenter);
        ValidFileDsGateway validPlayerInv =
                new ValidPlayerInventory(playerInvPath, presenter);

        GameCheckInteractor gameCheck = new GameCheckInteractor(validStats,
                validPlayerInv, validFightStats);
        Assertions.assertTrue(gameCheck.check());
        Assertions.assertTrue(gameCheck.valid());
    }

    @Test
    public void InvalidStatsFile(){
        String statsHeader = "gold, damage, level, defence, hp";
        String stats = "haha, 5, 1, 0, 100";
        generateStatsFile(statsPath, statsHeader, stats);

        ValidFileDsGateway validStats =
                new ValidStats(statsPath, presenter);
        ValidFileDsGateway validFightStats =
                new ValidStats(fightStatsPath, presenter);
        ValidFileDsGateway validPlayerInv =
                new ValidPlayerInventory(playerInvPath, presenter);


        GameCheckInteractor gameCheck = new GameCheckInteractor(validStats,
                validPlayerInv, validFightStats);

        Assertions.assertFalse(gameCheck.check());
        Assertions.assertFalse(gameCheck.valid());
    }

    @Test
    public void InvalidPlayerInvFile(){
        String playerInvHeader = "Player Inventory";
        String playerInvLabel = "item_id,item_type,item_name,item_effect," +
                "item_gold_value,item_is_equipped";
        String[] playerInvItems =
                        {"1,Weapon,Sword,13,1a,false",
                        "2,Potion,StrengthPotion,5,23,false",
                        "3,Weapon,Hammer,18,43,false",
                        "4,Shield,BronzeShield,15,20,false"};
        generateInvFiles(playerInvPath, playerInvHeader, playerInvLabel,
                playerInvItems);

        ValidFileDsGateway validStats =
                new ValidStats(statsPath, presenter);
        ValidFileDsGateway validFightStats =
                new ValidStats(fightStatsPath, presenter);
        ValidFileDsGateway validPlayerInv =
                new ValidPlayerInventory(playerInvPath, presenter);

        GameCheckInteractor gameCheck = new GameCheckInteractor(validStats,
                validPlayerInv, validFightStats);

        Assertions.assertFalse(gameCheck.valid());
        Assertions.assertFalse(gameCheck.check());
    }

    @Test
    public void InvalidFightStatsFile(){
        String fightStatsHeader = "playerDamage, playerDefence, " +
                "maxHealth, playerHealth, bossDamage, bossHealth";
        String fightStats = "5, 0, 100, 100, 9";
        fightStatsFile = generateStatsFile(fightStatsPath, fightStatsHeader,
                fightStats);

        ValidFileDsGateway validStats =
                new ValidStats(statsPath, presenter);
        ValidFileDsGateway validFightStats =
                new ValidStats(fightStatsPath, presenter);
        ValidFileDsGateway validPlayerInv =
                new ValidPlayerInventory(playerInvPath, presenter);

        GameCheckInteractor gameCheck = new GameCheckInteractor(validStats,
                validPlayerInv, validFightStats);

        Assertions.assertFalse(gameCheck.valid());
        Assertions.assertFalse(gameCheck.check());
    }


}
