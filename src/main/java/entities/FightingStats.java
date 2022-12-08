package entities;

/** The public interface for the FightingStats entity. FightingStats stores all the stats relevant to the player and
 * the boss during FightBoss, which includes temporary hp, temporary damage and temporary defence of the user
 * and the temporary hp of the boss.
 */
public interface FightingStats {

    public int getPlayerDamage();

    public int getBossDamage();

    public void changePlayerHP(int by);

    public void changePlayerDamage(int by);

    public void changePlayerDefence(int by);

    public void changeBossHP(int by);


}
