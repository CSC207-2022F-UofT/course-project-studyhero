package stats;

public interface Stats {

    public int getLevel();

    public int getGold();

    public int getHP();

    public int getDamage();

    public int getDefence();

    public int updateLevel();

    public int changeGold(int by);

    public int changeDamage(int by);

    public int changeHP(int by);

    public int changeDefence(int by);

}
