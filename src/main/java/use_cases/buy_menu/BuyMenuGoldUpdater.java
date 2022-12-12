package use_cases.buy_menu;

import entities.StatsUser;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;
import java.util.Map;


/**
 * interactor
 */
public class BuyMenuGoldUpdater {
    ValidStats stats;
    Map<String, Integer> statsMap;
    StatSave statSave;
    StatsUser statsUser;
    ErrorOutputBoundary presenter;



    public BuyMenuGoldUpdater() {
        stats = new ValidStats("stats.csv", presenter);
        statsMap = stats.load();
        statSave = new StatSave(statsMap, presenter);
        statsUser = new StatsUser(statsMap);
    }

    public void updateGoldFromPurchase(int price) {
        statsUser.updateGold(-price);
        System.out.println(statsUser.updateGold(-price));
        StatSave newStats = new StatSave(statsUser.getUserStats(), presenter);
        newStats.save("stats.csv");

        statsMap = stats.load();
        statSave = new StatSave(statsMap, presenter);
        statsUser = new StatsUser(statsMap);
    }


    /**
     * returns gold value
     */
    public int getUserGold() {
        return statsMap.get("gold");
    }

}
