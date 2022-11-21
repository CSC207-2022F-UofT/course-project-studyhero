package screens.panels;

import javax.swing.*;

import static UI.buttons.loadGame.loadGameButton.getLoadGameButton;
import static UI.buttons.newGame.newGameButton.getNewGameButton;
import static UI.buttons.quitGame.quitGameButton.getQuitGameButton;
import static UI.buttons.saveGame.saveGameButton.getSaveGameButton;

public class startPanel {
        public static JPanel startPanel() {
        //initialise new panel
        JPanel startPanel = new JPanel();
        JLabel title = new JLabel("Start Screen");

        //4 buttons to create new game, load existing game, save game, quit game
        JButton newGameButton = getNewGameButton();
        JButton loadGameButton = getLoadGameButton();
        JButton saveGameButton = getSaveGameButton();
        JButton quitGameButton = getQuitGameButton();

        startPanel.add(title);
        startPanel.add(newGameButton);
        startPanel.add(loadGameButton);
        startPanel.add(saveGameButton);
        startPanel.add(quitGameButton);

        return startPanel;
    }
}
