package use_cases.boss_fight;

public class FightDone {

    public FightDone(int winner){
        if (winner == 2){
            playerWin();
        } else{
            bossWin();
        }
    }

    public void playerWin(){

    }

    public void bossWin(){

    }
}
