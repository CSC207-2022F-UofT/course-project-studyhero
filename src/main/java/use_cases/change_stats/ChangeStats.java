package use_cases.change_stats;

import entities.StatsUser;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;

import java.util.Map;

public class ChangeStats {

    ErrorPresenter presenter;

    public ChangeStats(ErrorPresenter presenter){
        this.presenter = presenter;
    }

    public void updateLevel(){
        ValidStats stats = new ValidStats("stats.csv", presenter);
        Map<String, Integer> statsMap = stats.load();
        StatsUser intermediateUser = new StatsUser(statsMap);
        System.out.println(intermediateUser.updateLevel());
        StatSave saver = new StatSave(intermediateUser.getUserStats(), presenter);
        saver.save();
    }
}
