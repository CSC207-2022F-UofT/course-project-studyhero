package filesaver.usecases.game_check;

import filesaver.usecases.file_checker.ValidFileDsGateway;

public class GameCheckInteractor implements GameCheckInputBoundary{
    ValidFileDsGateway stats;
    ValidFileDsGateway inventory;
    ValidFileDsGateway fightStats;

    /**
     * Creates a GameCheckInteractor object that has ValidFileDsGateway attributes
     * and can check if each of them is a valid, playable file.
     *
     * @param stats         Player stats file
     * @param inventory     Player inventory file
     * @param fightStats    Player and boss fight stats file
     */
    public GameCheckInteractor(ValidFileDsGateway stats, ValidFileDsGateway inventory,
                               ValidFileDsGateway fightStats){
        this.stats = stats;
        this.inventory = inventory;
        this.fightStats = fightStats;
    }

    /**
     * @return true if all three files are valid, false if otherwise
     */
    @Override
    public boolean check(){
        return (stats.isPlayable() && inventory.isPlayable()
                && fightStats.isPlayable());
    }

    /**
     * @return true if all three files are valid, false if otherwise and
     * creates a new window displaying the error
     */
    @Override
    public boolean valid(){
        return (stats.isValid() && inventory.isValid() &&
                fightStats.isValid());
    }


}
