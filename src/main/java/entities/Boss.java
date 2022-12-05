package entities;

/** Interface for the boss entity that is needed during boss fights. Manages the maximum hp and current hp of the boss,
 * as well as the damage and defence.
 */
public interface Boss {
    /**
     * Returns the maximum possible hp for the boss.
     */
    int getMaxHp();

    /**
     * Returns the current hp of the boss.
     */
    int getCurrentHp();

    /**
     * Returns the damage the boss can inflict in one move.
     */
    int getDamage();

    /**
     * Returns the boss's defence stat.
     */
    int getDefence();

    /**
     * Updates the boss's current hp.
     */
    int updateCurrentHp();
}
