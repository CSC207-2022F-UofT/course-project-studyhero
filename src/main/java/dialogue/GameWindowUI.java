package dialogue;

import javax.swing.*;
import java.awt.*;

/*
Creates the window for "Game".
 */

public class GameWindowUI {

//    public GameWindowUI() { }

    public void createWindow() {
        // WINDOW
        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        window.setVisible(true);

    }

}
