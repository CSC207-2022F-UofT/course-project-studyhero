package stats.entities;

import java.util.Map;

/** The public interface for the Stats entity. Stats stores all the permanent stats relevant to the player
 * (i.e. stats which aren't just for the duration for the fights) which includes level, gold, maxHp, baselineDamage and
 * defence of the user and the hp of the boss.
 */
public interface Stats {
    /** Returns a map containing the type of stats (i.e. level, gold, hp, damage, defence) as the key and its
     * amount as the value.
     */
    Map<String, Integer> getUserStats();

    /** Changes the amount of gold the player has and returns the updated amount.
     *
     * @param by amount to change the gold by
     * @return new amount of gold
     */
    int updateGold(int by);

    /** Increases the player's level by 1 and returns the new level
     *
     * @return new level
     */
    int updateLevel();

    /** Changes the amount of damage that can be done by the user and returns the new value.
     * @param by amount to change by
     * @return new damage value
     */
    int updateBaselineDamage(int by);

    /** Changes the ability of the user to defend themselves and returns the new value.
     * @param by amount to change by
     * @return new defence value
     */
    int updateDefence(int by);

}
