package filesave.newgame;

import UI.screens.panels.ConfirmationWindowView;
import org.junit.jupiter.api.*;
import errors.usecases.ErrorOutputBoundary;
import errors.usecases.ErrorPresenter;
import filesaver.usecases.file_checker.ValidFileDsGateway;
import filesaver.usecases.file_checker.ValidPlayerInventory;
import filesaver.usecases.file_checker.ValidShopInventory;
import filesaver.usecases.file_checker.ValidStats;
import filesaver.usecases.game_check.GameCheckInputBoundary;
import filesaver.usecases.game_check.GameCheckInteractor;
import filesaver.usecases.new_game.NewGame;
import filesaver.usecases.new_game.NewGameController;
import filesaver.usecases.new_game.NewGameInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class NewGameControllerTest {

    CardLayout card = new CardLayout();
    JPanel panel = new JPanel();
    JPanel storyPanel = new JPanel();
    ErrorOutputBoundary presenter = new ErrorPresenter();
    static String statsFilepath = "statsTest.csv";
    static String plyrInvFilepath = "PlayerInventoryTest.csv";
    static String shpInvFilepath = "ShopInventoryTest.csv";
    static String fightStatsFilepath = "fightStatsTest.csv";

    private static File statsFile = new File(statsFilepath);
    private static File plyrInvFile = new File(plyrInvFilepath);
    private static final File shpInvFile = new File(shpInvFilepath);
    private static File fightStatsFile = new File(fightStatsFilepath);
    ValidFileDsGateway statsUC =
            new ValidStats(statsFilepath, presenter);
    ValidFileDsGateway plyrInvUC =
            new ValidPlayerInventory(plyrInvFilepath, presenter);
    ValidFileDsGateway shpInvUC =
            new ValidShopInventory(shpInvFilepath, presenter);
    ValidFileDsGateway fightStatsUC =
            new ValidStats(fightStatsFilepath, presenter);

    ConfirmationWindowView confirmationWindow;

    public void write(String filename, String content){
        try{
            File newFile = new File(filename);
            PrintWriter out = new PrintWriter(newFile);

            out.println(content);
            out.close();

        } catch (IOException e){
            presenter.error(e.toString());
        }
    }
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

    public void initialiseValidFiles1(){
        String statsHeader = "gold, damage, level, defence, hp";
        String stats = "100, 5, 1, 0, 100";
        statsFile = generateStatsFile(statsFilepath, statsHeader, stats);

        String fightStatsHeader = "playerDamage, playerDefence, " +
                "maxHealth, playerHealth, bossDamage, bossHealth";
        String fightStats = "5, 0, 100, 100, 9, 12";
        fightStatsFile = generateStatsFile(fightStatsFilepath, fightStatsHeader,
                fightStats);

        String playerInvHeader = "Player Inventory";
        String playerInvLabel = "item_id,item_type,item_name,item_effect," +
                "item_gold_value,item_is_equipped";
        String[] playerInvItems =
                {"1,Weapon,Sword,13,10,false",
                        "2,AttackPotion,StrengthPotion,5,23,false",
                        "3,Weapon,Hammer,18,43,false",
                        "4,Shield,BronzeShield,15,20,false"};
        plyrInvFile = generateInvFiles(plyrInvFilepath, playerInvHeader,
                playerInvLabel, playerInvItems);

    }

    public void initialiseValidFiles2(){
        String statsHeader = "gold, damage, level, defence, hp, faith, cringe";
        String stats = "10, 56, 19, 00, 100, 90, 8";
        statsFile = generateStatsFile(statsFilepath, statsHeader, stats);

        String fightStatsHeader = "playerDamage, playerDefence, " +
                "maxHealth, playerHealth";
        String fightStats = "50, 0, 100, 99999";
        fightStatsFile = generateStatsFile(fightStatsFilepath, fightStatsHeader,
                fightStats);

        String playerInvHeader = "Player Inventory";
        String playerInvLabel = "item_id,item_type,item_name,item_effect," +
                "item_gold_value,item_is_equipped";
        String[] playerInvItems =
                {"1,Weapon,Sword,13,10,true",
                        "2,HealthPotion,StrengthPotion,5,23,false",
                        "3,Weapon,Hammer,18,43,false",
                        "4,Shield,BronzeShield,15,21,true"};
        plyrInvFile = generateInvFiles(plyrInvFilepath, playerInvHeader,
                playerInvLabel, playerInvItems);

    }

    public void initialiseInvalidFiles(){
        String invStatsCont = "invalidStats",
                invPlyrCont = "invalidInv",
                invShpCont = "invalidShop",
                invFightCont = "weird fight stats";
        write(statsFilepath, invStatsCont);
        write(plyrInvFilepath, invPlyrCont);
        write(shpInvFilepath, invShpCont);
        write(fightStatsFilepath, invFightCont);
    }
    @BeforeEach
    public void SetUp(){
        confirmationWindow = new ConfirmationWindowView("confirm",
                card, panel, presenter);
        panel.setLayout(card);
        panel.add(storyPanel, "Story");
    }
    @AfterEach
    public void cleanUp(){
        statsFile.deleteOnExit();
        plyrInvFile.deleteOnExit();
        shpInvFile.deleteOnExit();
        fightStatsFile.deleteOnExit();
    }

    @Test
    public void ConfirmationCreatedBaseFiles(){
        initialiseValidFiles1();
        GameCheckInputBoundary gameCheck =
                new GameCheckInteractor(statsUC, plyrInvUC, fightStatsUC);
        NewGameInputBoundary newGame =
                new NewGame(statsUC, plyrInvUC, fightStatsUC, presenter);


        NewGameController controller = new NewGameController(card, panel,
                gameCheck, newGame, confirmationWindow);
        ActionEvent e1 = new ActionEvent(new Object(), 1, "confirm");

        Assertions.assertTrue(gameCheck.check());
        controller.actionPerformed(e1);
        Assertions.assertTrue(confirmationWindow.isVisible());
    }

    @Test
    public void ConfirmationCreatedValidChangedFiles(){
        initialiseValidFiles2();
        GameCheckInputBoundary gameCheck =
                new GameCheckInteractor(statsUC, plyrInvUC, fightStatsUC);
        NewGameInputBoundary newGame =
                new NewGame(statsUC, plyrInvUC, fightStatsUC, presenter);


        NewGameController controller = new NewGameController(card, panel,
                gameCheck, newGame, confirmationWindow);
        ActionEvent e1 = new ActionEvent(new Object(), 1, "confirm");

        Assertions.assertTrue(gameCheck.check());
        controller.actionPerformed(e1);
        Assertions.assertTrue(confirmationWindow.isVisible());
    }

    @Test
    public void NewFilesCreatedFromInvalidFiles(){
        initialiseInvalidFiles();
        Assertions.assertTrue((shpInvFile.exists()&& plyrInvFile.exists()
                && shpInvFile.exists() && fightStatsFile.exists()));
        GameCheckInputBoundary gameCheck =
                new GameCheckInteractor(statsUC, plyrInvUC, fightStatsUC);
        NewGameInputBoundary newGame =
                new NewGame(statsUC, plyrInvUC, fightStatsUC, presenter);

        NewGameController controller = new NewGameController(card, panel,
                gameCheck, newGame, confirmationWindow);
        controller.setStatsPath(statsFilepath);
        controller.setPlyrInvPath(plyrInvFilepath);
        controller.setShpInvPath(shpInvFilepath);
        controller.setFightStatsPath(fightStatsFilepath);
        ActionEvent e1 = new ActionEvent(new Object(), 1, "confirm");

        Assertions.assertFalse(gameCheck.check());
        controller.actionPerformed(e1);
        Assertions.assertFalse(confirmationWindow.isVisible());

        Assertions.assertTrue((statsFile.exists()&& plyrInvFile.exists()
                && shpInvFile.exists() && fightStatsFile.exists()));
        Assertions.assertEquals(panel.getComponent(0), storyPanel);
    }
}
