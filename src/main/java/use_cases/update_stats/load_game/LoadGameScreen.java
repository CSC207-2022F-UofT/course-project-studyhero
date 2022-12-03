package use_cases.update_stats.load_game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadGameScreen extends JPanel implements ActionListener {
    LoadGameController controller;

    public LoadGameScreen(LoadGameController controller){
        this.controller = controller;
        JLabel title = new JLabel("Load Game");
        JButton loadButton = new JButton("Load Here");
        loadButton.addActionListener(this);

        this.add(title);
        this.add(loadButton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        try{
            controller.load();
        } catch(Exception ex){
            System.out.println("Error occurred.");
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }
}
