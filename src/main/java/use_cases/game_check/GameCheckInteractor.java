package use_cases.game_check;

import use_cases.file_checker.ValidFileDsGateway;

public class GameCheckInteractor implements GameCheckInputBoundary{
    ValidFileDsGateway stats;
    ValidFileDsGateway inventory;
    ValidFileDsGateway fightStats;

    public GameCheckInteractor(ValidFileDsGateway stats, ValidFileDsGateway inventory,
                               ValidFileDsGateway fightStats){
        this.stats = stats;
        this.inventory = inventory;
        this.fightStats = fightStats;
    }
    @Override
    public boolean valid(){
        return (stats.isValid() && inventory.isValid() &&
                fightStats.isValid());
    }

    @Override
    public boolean check(){
        return (stats.isPlayable() && inventory.isPlayable()
                && fightStats.isPlayable());
    }
}
