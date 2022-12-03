package use_cases.new_game;

import entities.StatsUser;
import use_cases.errors.ErrorPresenter;
import use_cases.save_game.StatSave;

import java.io.File;

public class NewGame {

    public NewGame(String filename) {
        File file = new File(filename);
        if (file.exists() && !file.isDirectory()){
            System.out.println("File exists. Overwriting...");
        }
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("New save.");
        }
        StatsUser newUser = new StatsUser();
        ErrorPresenter presenter = new ErrorPresenter();
        StatSave newSave = new StatSave(newUser.getUserStats(), presenter);
        newSave.save();
    }
}
