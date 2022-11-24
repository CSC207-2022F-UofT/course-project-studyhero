package entities;

/** Interface for the boss entity that is needed during boss fights. Manages the maximum hp and current hp of the boss,
 * as well as the damage and defence.
 */
public interface Boss {
    int getMaxHp();
    int getCurrentHp();
    int getDamage();
    int getDefence();
}
