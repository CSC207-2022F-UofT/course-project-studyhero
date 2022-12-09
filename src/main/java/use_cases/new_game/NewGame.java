package use_cases.new_game;

import entities.FightingStatsInitializer;
import entities.StatsUser;
import entities.inventoryitem.InitializePlayerInventoryGateway;
import entities.inventoryitem.InitializeShopInventoryGateway;
import entities.inventoryitem.PlayerInventoryFile;
import entities.inventoryitem.ShopInventoryFile;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.save_game.StatSave;

import java.util.Map;

/**
 * A use case responsible for initialising new game files and storing them
 * in memory.
 */
public class NewGame implements NewGameInputBoundary{
    private final ValidFileDsGateway statsFile;
    private final ValidFileDsGateway playerInventoryFile;
    private final ValidFileDsGateway shopInventoryFile;
    private final ValidFileDsGateway fightStatsFile;
    private final ErrorOutputBoundary presenter;

    /**
     * Creates a NewGame object that checks for the existence of necessary
     * game files and initialises a new game by either overwriting existing
     * files or writing new ones.
     *
     * @param statsFile             Player stats file
     * @param playerInventoryFile   Player inventory file
     * @param shopInventoryFile     Shop inventory file
     * @param fightStatsFile        Fight stats file
     * @param presenter             Output boundary if any error occurs
     */
    public NewGame(ValidFileDsGateway statsFile,
                   ValidFileDsGateway playerInventoryFile,
                   ValidFileDsGateway shopInventoryFile,
                   ValidFileDsGateway fightStatsFile,
                   ErrorOutputBoundary presenter) {
        this.statsFile = statsFile;
        this.playerInventoryFile = playerInventoryFile;
        this.shopInventoryFile = shopInventoryFile;
        this.fightStatsFile = fightStatsFile;
        this.presenter = presenter;
    }

    /**
     * Creates new game files: stats, player inventory, shop inventory
     * and fight stats and saves them in memory.
     */
    @Override
    public void newGame(){
        //if any file exists, will print that files are being overwritten
        if (statsFile.fileExists() || playerInventoryFile.fileExists()
                || shopInventoryFile.fileExists() || fightStatsFile.fileExists()){
            System.out.println("Files exist. Overwriting...");
        }else{
            System.out.println("New save.");
        }
        // initialise a new player and saves it
        StatsUser newUser = new StatsUser();
        StatSave newSave = new StatSave(newUser.getUserStats(), presenter);
        newSave.save("stats.csv");

        // initialise a new player inventory list and saves it
        InitializePlayerInventoryGateway playerInventoryList =
                new PlayerInventoryFile("PlayerInventory.csv");
        playerInventoryList.initialize();

        // initialise a new shop inventory list and saves it
        InitializeShopInventoryGateway shopInventoryList =
                new ShopInventoryFile("ShopInventory.csv");
        shopInventoryList.initialize();

        // initialise a new fighting stats file and saves it
        FightingStatsInitializer fightingStatsInitializer =
                new FightingStatsInitializer();
        Map<String, Integer> fightStats = fightingStatsInitializer.initialize();
        StatSave saver = new StatSave(fightStats, presenter);
        saver.save("fightStats.csv");

    }
}
