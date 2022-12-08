package use_cases.new_game;

import entities.CurrentFightingStats;
import entities.StatsUser;
import inventorymenu.inventoryitem.InventoryList;
import inventorymenu.inventoryitem.PlayerInventoryFile;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.save_game.StatSave;

import java.util.Map;


public class NewGame implements NewGameInputBoundary{
    private final ValidFileDsGateway statsFile;
    private final ValidFileDsGateway inventoryFile;
    private final ValidFileDsGateway fightStatsFile;
    private final ErrorOutputBoundary presenter;

    public NewGame(ValidFileDsGateway statsFile,
                   ValidFileDsGateway inventoryFile,
                   ValidFileDsGateway fightStatsFile,
                   ErrorOutputBoundary presenter) {
        this.statsFile = statsFile;
        this.inventoryFile = inventoryFile;
        this.fightStatsFile = fightStatsFile;
        this.presenter = presenter;
    }

    public boolean isPlayable(){

        return (statsFile.isPlayable() && inventoryFile.isPlayable());
    }

    public void newGame(){
        if (statsFile.fileExists() && inventoryFile.fileExists()
                && fightStatsFile.fileExists()){
            System.out.println("Files exist. Overwriting...");
        }else{
            System.out.println("New save.");
        }
        // initialise a new player and saves it
        StatsUser newUser = new StatsUser();
        StatSave newSave = new StatSave(newUser.getUserStats(), presenter);
        newSave.save("stats.csv");

        // initialise a new inventory list and saves it
        InventoryList inventoryList = new PlayerInventoryFile("PlayerInventory.csv");
        inventoryList.initialize();

        // initialise a new fightingStats object and saves it

        //CurrentFightingStats fightingStats = new CurrentFightingStats();
        //fightingStats.initializeFight();
        //System.out.println(fightingStats.getUpdatedFightStats());
        //fightingStats.saveFightStats();

    }
}
