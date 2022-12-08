package use_cases.new_game;

import entities.StatsUser;
import inventorymenu.inventoryitem.InventoryList;
import inventorymenu.inventoryitem.PlayerInventoryFile;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidInventory;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;

import java.io.File;

public class NewGame {
    File file;
    ValidStats statsFile;
    ValidPlayerInventory inventoryFile;
    final ErrorOutputBoundary presenter;

    public NewGame(String filename, ErrorOutputBoundary presenter) {
        this.file = new File(filename);
        this.presenter = presenter;
        this.statsFile = new ValidStats("stats.csv", this.presenter);
        this.inventoryFile = new ValidPlayerInventory("PlayerInventory.csv", this.presenter);
    }

    public boolean isPlayable(){
        return (statsFile.isPlayable() && inventoryFile.isPlayable());
    }

    public void createNewStatsFile(){
        if (file.exists() && !file.isDirectory()){
            System.out.println("File exists. Overwriting...");
        }
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("New save.");
        }
        StatsUser newUser = new StatsUser();
        StatSave newSave = new StatSave(newUser.getUserStats(), presenter);
        newSave.save("stats.csv");
    }
    public void newGame(){
        this.createNewStatsFile();
        new PlayerInventoryFile("PlayerInventory.csv");
    }
}
