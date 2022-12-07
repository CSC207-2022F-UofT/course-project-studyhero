package use_cases.stats_update_use_case;

/**
 * Interactor for updating stats. Contains methods to update each kind of user stat individually.
 */
public interface StatsUpdateInterface {
    /**
     * Updates the user's level by 1 and makes any necessary changes to all other stats that depend on the level.
     */
    void updateLevel();

    /**
     * Updates gold by amount changeBy.
     *
     * @param changeBy amount to change gold by. Can be negative, in which case gold will decrease.
     */
    void updateGold(int changeBy);

    /**
     * Updates the user's current hp by amount changeBy.
     *
     * @param changeBy amount by which current hp should change. Can be negative, in which case hp will decrease.
     */
    void updateCurrentHp(int changeBy);

    /**
     * Updates the user's current damage by amount changeBy.
     *
     * @param changeBy amount to change current damage by. Can be negative, in which case it will decrease.
     */
    void updateTempDamage(int changeBy);

    /**
     * Updates the user's baseline damage by amount changeBy.
     *
     * @param changeBy amount to change baseline damage by. Can be negative, in which case it will decrease.
     */
    void updateBaselineDamage(int changeBy);

    /**
     * Updates the user's defence by amount changeBy.
     *
     * @param changeBy amount to change defence by. Can be negative, in which case it will decrease.
     */
    void updateDefence(int changeBy);
}
