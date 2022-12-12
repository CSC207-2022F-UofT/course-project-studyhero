package filesave.continuegame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.continue_game.ContinueGameController;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidStats;
import use_cases.game_check.GameCheckInputBoundary;
import use_cases.game_check.GameCheckInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ContinueGameControllerTest {

    CardLayout card = new CardLayout();
    JPanel parent = new JPanel();
    JPanel other = new JPanel();
    JPanel timer = new JPanel();

    private final ErrorOutputBoundary presenter = new ErrorPresenter();
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

    public void initialiseInvalidFiles(){
        String statsHeader = "gold, damage, level, defence, hp";
        String stats = "100, 5, 1, 0, pop";
        statsFile = generateStatsFile(statsPath, statsHeader, stats);

        String fightStatsHeader = "playerDamage, playerDefence, " +
                "maxHealth, playerHealth, bossDamage, bossHealth";
        String fightStats = "5, 0, 100, 100, 9, 12, wow";
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
        JLabel timerL = new JLabel("timer");
        JLabel otherL = new JLabel("other");
        timer.add(timerL);
        other.add(otherL);
        parent.add(timer, "Timer");
        parent.add(other, "other");
        parent.setLayout(card);
        card.show(parent, "other");
    }
    @AfterEach
    public void deleteTestFiles(){
        statsFile.deleteOnExit();
        playerInvFile.deleteOnExit();
        fightStatsFile.deleteOnExit();
    }
    @Test
    public void validGame(){
        initialiseValidFiles();
        ValidFileDsGateway stats = new ValidStats(statsPath, presenter);
        ValidFileDsGateway playerInv = new ValidPlayerInventory(playerInvPath, presenter);
        ValidFileDsGateway fightStats = new ValidStats(fightStatsPath, presenter);
        GameCheckInputBoundary gameCheck =
                new GameCheckInteractor(stats, playerInv, fightStats);
        ContinueGameController continueGameController =
                new ContinueGameController(card, parent, gameCheck);

        ActionEvent e = new ActionEvent(new Object(), 1, "valid");

        continueGameController.actionPerformed(e);
        Assertions.assertTrue(gameCheck.check());
        Assertions.assertEquals(parent.getComponent(0), timer);
    }

    @Test
    public void invalidGame(){
        initialiseInvalidFiles();
        ValidFileDsGateway stats = new ValidStats(statsPath, presenter);
        ValidFileDsGateway playerInv = new ValidPlayerInventory(playerInvPath, presenter);
        ValidFileDsGateway fightStats = new ValidStats(fightStatsPath, presenter);
        GameCheckInputBoundary gameCheck =
                new GameCheckInteractor(stats, playerInv, fightStats);
        ContinueGameController continueGameController =
                new ContinueGameController(card, parent, gameCheck);

        ActionEvent e = new ActionEvent(new Object(), 1, "invalid");

        continueGameController.actionPerformed(e);
        Assertions.assertFalse(gameCheck.valid());
        Assertions.assertTrue(other.isVisible());
    }

}
