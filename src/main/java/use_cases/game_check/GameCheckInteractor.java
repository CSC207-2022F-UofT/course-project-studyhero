package use_cases.game_check;

import use_cases.file_checker.ValidFileDsGateway;

public class GameCheckInteractor implements GameCheckInputBoundary{
    ValidFileDsGateway stats;
    ValidFileDsGateway inventory;

    public GameCheckInteractor(ValidFileDsGateway stats, ValidFileDsGateway inventory){
        this.stats = stats;
        this.inventory = inventory;
    }
    @Override
    public boolean valid(){
        return (stats.isValid() && inventory.isValid());
    }

    @Override
    public boolean check(){
        return (stats.isPlayable() && inventory.isPlayable() );
    }
}
