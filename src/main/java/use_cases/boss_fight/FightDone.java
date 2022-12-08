package use_cases.boss_fight;

import javax.swing.*;
import java.awt.*;

public class FightDone {
    private CardLayout card;
    private JPanel mainPanel;

    public FightDone(int winner, CardLayout card, JPanel mainPanel){

        this.card = card;
        this.mainPanel = mainPanel;
        if (winner == 2){
            playerWin();
        } else if (winner == 1){
            bossWin();
        }
    }

    public void playerWin(){
        card.show(mainPanel, "Break");
    }

    public void bossWin(){
        card.show(mainPanel, "Break");
    }
}
