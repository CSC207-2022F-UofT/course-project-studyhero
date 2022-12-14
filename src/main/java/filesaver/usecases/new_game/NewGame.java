package filesaver.usecases.new_game;

import bossfight.FightingStatsInitializer;
import stats.entities.StatsUser;
import inventory.entities.InitializePlayerInventoryGateway;
import inventory.entities.InitializeShopInventoryGateway;
import inventory.entities.PlayerInventoryFile;
import inventory.entities.ShopInventoryFile;
import errors.usecases.ErrorOutputBoundary;
import filesaver.usecases.file_checker.ValidFileDsGateway;
import filesaver.usecases.save_game.StatSave;

import java.util.Map;

/**
 * A use case responsible for initialising new game files and storing them
 * in memory.
 */
public class NewGame implements NewGameInputBoundary{
    private final ValidFileDsGateway statsFile;
    private final ValidFileDsGateway inventoryFile;
    private final ValidFileDsGateway fightStatsFile;
    private final ErrorOutputBoundary presenter;

    /**
     * Creates a NewGame object that checks for the existence of necessary
     * game files and initialises a new game by either overwriting existing
     * files or writing new ones.
     *
     * @param statsFile             Player stats file
     * @param inventoryFile   Player inventory file
     * @param fightStatsFile        Fight stats file
     * @param presenter             Output boundary if any error occurs
     */
    public NewGame(ValidFileDsGateway statsFile,
                   ValidFileDsGateway inventoryFile,
                   ValidFileDsGateway fightStatsFile,
                   ErrorOutputBoundary presenter) {
        this.statsFile = statsFile;
        this.inventoryFile = inventoryFile;
        this.fightStatsFile = fightStatsFile;
        this.presenter = presenter;
    }

    /**
     * Creates new game files: stats, player inventory, shop inventory
     * and fight stats and saves them in memory.
     */
    @Override
    public void newGame(String statsPath, String playerInvPath,
                        String shopInvPath, String fightStatsPath){
        //if any file exists, will print that files are being overwritten
        if (statsFile.fileExists() || inventoryFile.fileExists()
                || fightStatsFile.fileExists()){
            System.out.println("Files exist. Overwriting...");
        }else{
            System.out.println("New save.");
        }
        // initialise a new player and saves it
        StatsUser newUser = new StatsUser();
        StatSave newSave = new StatSave(newUser.getUserStats(), presenter);
        newSave.save(statsPath);

        // initialise a new player inventory list and saves it
        InitializePlayerInventoryGateway playerInventoryList =
                new PlayerInventoryFile(playerInvPath);
        playerInventoryList.initialize();

        // initialise a new shop inventory list and saves it
        InitializeShopInventoryGateway shopInventoryList =
                new ShopInventoryFile(shopInvPath);
        shopInventoryList.initialize();

        // initialise a new fighting stats file and saves it
        FightingStatsInitializer fightingStatsInitializer =
                new FightingStatsInitializer();
        Map<String, Integer> fightStats = fightingStatsInitializer.initialize();
        StatSave saver = new StatSave(fightStats, presenter);
        saver.save(fightStatsPath);

    }
}
