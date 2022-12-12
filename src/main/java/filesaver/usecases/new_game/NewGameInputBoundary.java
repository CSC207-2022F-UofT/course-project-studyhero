package filesaver.usecases.new_game;

/**
 * Input boundary that can create new game files
 */
public interface NewGameInputBoundary{
    void newGame(String statsPath, String playerInvPath,
                 String shopInvPath, String fightStatsPath);

}
