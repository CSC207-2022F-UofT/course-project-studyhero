package controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidShopInventory;
import use_cases.file_checker.ValidStats;
import use_cases.new_game.NewGame;
import use_cases.new_game.confirmation_window.NewGameConfirmationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class NewGameConfirmationControllerTest {

    CardLayout card = new CardLayout();
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JPanel storyPanel = new JPanel();

    String statsFilepath = "statsTest.csv",
            plyrInvFilepath = "PlayerInventoryTest.csv",
            shpInvFilepath = "ShopInventoryTest.csv",
            fightStatsFilepath = "fightStatsTest.csv";
    File stats = new File(statsFilepath),
            plyrInv = new File(plyrInvFilepath),
            shpInv = new File(shpInvFilepath),
            fightStats = new File(fightStatsFilepath);
    ErrorOutputBoundary presenter = new ErrorPresenter();

    ValidFileDsGateway statsFile =
            new ValidStats(statsFilepath, presenter);
    ValidFileDsGateway playerInventoryFile =
            new ValidPlayerInventory(plyrInvFilepath, presenter);
    ValidFileDsGateway shopInventoryFile =
            new ValidShopInventory(shpInvFilepath, presenter);
    ValidFileDsGateway fightStatsFile =
            new ValidStats(fightStatsFilepath, presenter);

    NewGame newGame = new NewGame(statsFile, playerInventoryFile,
            shopInventoryFile, fightStatsFile, presenter);

    @BeforeEach
    public void setUp(){
        panel.setLayout(card);
        panel.add(storyPanel, "Story");
        frame.add(panel);
        NewGameConfirmationController controller =
                new NewGameConfirmationController(card, panel, frame, newGame);
        ActionEvent e1 = new ActionEvent(new Object(), 1, "new");
        controller.setStatsPath(statsFilepath);
        controller.setPlyrInvPath(plyrInvFilepath);
        controller.setShpInvPath(shpInvFilepath);
        controller.setFightStatsPath(fightStatsFilepath);
        controller.actionPerformed(e1);
    }

    @AfterEach
    public void cleanUp(){
        if(stats.exists()){Assertions.assertTrue(stats.delete());}
        if(plyrInv.exists()){Assertions.assertTrue(plyrInv.delete());}
        if(shpInv.exists()){Assertions.assertTrue(shpInv.delete());}
        if(fightStats.exists()){Assertions.assertTrue(fightStats.delete());}
    }

    @Test
    public void createsNewFiles(){
        Assertions.assertTrue((stats.exists()&& plyrInv.exists()
                && shpInv.exists() && fightStats.exists()));
    }
    @Test
    public void disposeFrame(){
        Assertions.assertFalse(frame.isActive());
    }
    @Test
    public void showStoryPanel(){
        Assertions.assertEquals(panel.getComponent(0), storyPanel);
    }

}
