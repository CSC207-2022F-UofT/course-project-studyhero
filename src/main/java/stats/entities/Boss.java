package stats.entities;

/** Interface for the boss entity that is needed during boss fights. Manages the maximum hp and current hp of the boss,
 * as well as the damage and defence.
 */
public interface Boss {
    /**
     * Returns the maximum possible hp for the boss.
     */
    int getMaxHp();

    /**
     * Returns the current hp of the boss, which can be less than or equal to the maximum hp.
     */
    int getCurrentHp();

    /**
     * Returns the damage the boss can inflict in one move.
     */
    int getDamage();


    /**
     * Updates the boss's current hp by amount changeBy and returns the new hp.
     *
     * @param changeBy amount to change currentHp by
     * @return new current hp
     */
    int updateCurrentHp(int changeBy);
}
