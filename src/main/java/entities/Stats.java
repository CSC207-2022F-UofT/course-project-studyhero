package entities;

import java.util.Map;

/** The public interface for the Stats entity. Stats stores all the stats relevant to the player and the boss,
 * which includes level, gold, hp, damage and defence of the user and the hp of the boss.
 */
public interface Stats {
    /** Returns a map containing the type of stats (i.e. level, gold, hp, damage, defence or bosshp) as the key and its
     * amount as the value.
     */
    public Map<String, Integer> getUserStats();

    /** Changes the amount of gold the player has and returns the updated amount.
     *
     * @param by amount to change the gold by
     * @return new amount of gold
     */
    public int changeGold(int by);

    /** Increases the player's level by 1 and returns the new level
     *
     * @return new level
     */
    public int updateLevel();

    /** Changes the amount of damage that can be done by the user and returns the new value.
     * @param by amount to change by
     * @return new damage value
     */
    public int changeDamage(int by);

    /** Changes the amount of hp that the user has and returns the new value.
     * @param by amount to change by
     * @return new hp value
     */
    public int changeHP(int by);

    /** Changes the ability of the user to defend themselves and returns the new value.
     * @param by amount to change by
     * @return new defence value
     */
    public int changeDefence(int by);

}
