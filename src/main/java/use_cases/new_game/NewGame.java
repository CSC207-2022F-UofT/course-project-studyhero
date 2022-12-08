package use_cases.new_game;

import entities.StatsUser;
import inventorymenu.inventoryitem.InventoryList;
import inventorymenu.inventoryitem.PlayerInventoryFile;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidStats;
import use_cases.save_stats.StatSave;


public class NewGame implements NewGameInputBoundary{
    private final ValidFileDsGateway statsFile;
    private final ValidFileDsGateway inventoryFile;
    private final ErrorOutputBoundary presenter;

    public NewGame(ValidFileDsGateway statsFile,
                   ValidFileDsGateway inventoryFile, ErrorOutputBoundary presenter) {
        this.statsFile = statsFile;
        this.inventoryFile = inventoryFile;
        this.presenter = presenter;
    }

    public boolean isPlayable(){

        return (statsFile.isPlayable() && inventoryFile.isPlayable());
    }

    public void newGame(){
        if (statsFile.fileExists() && inventoryFile.fileExists()){
            System.out.println("Files exist. Overwriting...");
        }else{
            System.out.println("New save.");
        }
        StatsUser newUser = new StatsUser();
        StatSave newSave = new StatSave(newUser.getUserStats(), presenter);
        newSave.save();

        InventoryList inventoryList = new PlayerInventoryFile("PlayerInventory.csv");
        inventoryList.initialize();
    }
}
