package dialogue;

import javax.swing.*;
import java.awt.*;

/*
Creates the window for "Game".
 */

public class GameWindowUI {

    Font titleFont = new Font("Papyrus", Font.PLAIN, 80);

//    public GameWindowUI() { }

    public void createWindow() {
        // WINDOW
        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        // TITLE SCREEN PANEL
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.blue);

        // TITLE TEXT
        JLabel titleNameLabel = new JLabel("STUDY HERO");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titlePanel.add(titleNameLabel);


        window.add(titlePanel);
        window.setVisible(true);

    }

}
