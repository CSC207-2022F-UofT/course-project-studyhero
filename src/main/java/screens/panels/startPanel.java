package screens.panels;

import javax.swing.*;

import static UI.buttons.load_game.loadGameButton.getLoadGameButton;
import static UI.buttons.new_game.newGameButton.getNewGameButton;
import static UI.buttons.quit_game.quitGameButton.getQuitGameButton;
import static UI.buttons.save_game.saveGameButton.getSaveGameButton;

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
