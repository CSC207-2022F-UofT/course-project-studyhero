package file_checker;

import org.junit.jupiter.api.*;
import errors.usecases.ErrorOutputBoundary;
import errors.usecases.ErrorPresenter;
import filesaver.usecases.file_checker.ValidFileDsGateway;
import filesaver.usecases.file_checker.ValidPlayerInventory;
import filesaver.usecases.file_checker.ValidShopInventory;
import filesaver.usecases.file_checker.ValidStats;
import filesaver.usecases.new_game.NewGame;

import java.io.*;

public class NewGameTest {

    //methods to test: newGame - initialises and saves four files

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
            fightStatsFile, presenter);

    public String read(File file){
        try {
            BufferedReader br = new BufferedReader( new FileReader(file));
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
    public void deleteFiles(){
        stats.deleteOnExit();
        plyrInv.deleteOnExit();
        shpInv.deleteOnExit();
        fightStats.deleteOnExit();
    }
    @BeforeEach
    public void setUp(){
        if(stats.exists()){Assertions.assertTrue(stats.delete());}
        if(plyrInv.exists()){Assertions.assertTrue(plyrInv.delete());}
        if(shpInv.exists()){Assertions.assertTrue(shpInv.delete());}
        if(fightStats.exists()){Assertions.assertTrue(fightStats.delete());}
    }

    @Test
    public void testCreatesGame(){
        Assertions.assertFalse(stats.exists());
        Assertions.assertFalse(plyrInv.exists());
        Assertions.assertFalse(shpInv.exists());
        Assertions.assertFalse(fightStats.exists());

        newGame.newGame(statsFilepath, plyrInvFilepath,
                shpInvFilepath, fightStatsFilepath);
        Assertions.assertTrue(stats.exists());
        Assertions.assertTrue(plyrInv.exists());
        Assertions.assertTrue(shpInv.exists());
        Assertions.assertTrue(fightStats.exists());

        deleteFiles();
    }

    @Test
    public void testOverwritesGame(){
        String invStatsCont = "invalidStats",
                invPlyrCont = "invalidInv",
                invShpCont = "invalidShop",
                invFightCont = "weird fight stats";
        write(statsFilepath, invStatsCont);
        write(plyrInvFilepath, invPlyrCont);
        write(shpInvFilepath, invShpCont);
        write(fightStatsFilepath, invFightCont);

        Assertions.assertTrue(stats.exists());
        Assertions.assertTrue(plyrInv.exists());
        Assertions.assertTrue(shpInv.exists());
        Assertions.assertTrue(fightStats.exists());

        //overwrite
        newGame.newGame(statsFilepath, plyrInvFilepath,
                shpInvFilepath, fightStatsFilepath);

        Assertions.assertTrue(stats.exists());
        Assertions.assertTrue(plyrInv.exists());
        Assertions.assertTrue(shpInv.exists());
        Assertions.assertTrue(fightStats.exists());

        Assertions.assertNotEquals(invStatsCont, read(stats));
        Assertions.assertNotEquals(invPlyrCont, read(plyrInv));
        Assertions.assertNotEquals(invShpCont, read(shpInv));
        Assertions.assertNotEquals(invFightCont, read(fightStats));

        deleteFiles();
    }

}
