package screens;

import screens.panels.breakPanel;
import screens.panels.startPanel;

import javax.swing.*;
import java.awt.*;

public class mainCard {
    final static CardLayout mainCard = new CardLayout(3, 5);
    public static JPanel mainPanel = new JPanel();
    public static CardLayout getCard(){
        return mainCard;
    }

    public mainCard(){

        mainPanel.setLayout(mainCard);
    }
    public static void switchScreens(JPanel panelName, String index){

        mainCard.show(panelName, index);
    }

    public static void show(String index) {
        mainCard.show(mainPanel, index);
    }
}
