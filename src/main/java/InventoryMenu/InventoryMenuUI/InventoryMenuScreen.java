package InventoryMenu.InventoryMenuUI;

import InventoryMenu.inventory_menu_use_case.display_player_inventory.PlayerDisplayInventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryMenuScreen extends JFrame implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);


    /**
     * The controller
     */

    PlayerDisplayInventoryController playerDisplayInventoryController;
    /**
     * A window with a title and a JButton.
     */
    public InventoryMenuScreen(PlayerDisplayInventoryController controller) {

        this.playerDisplayInventoryController = controller;

        JLabel title = new JLabel("InventoryMenu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("DisplayPlayerInventory"), username);


        JButton logIn = new JButton("DisplayPlayerInventory");


        JPanel buttons = new JPanel();
        buttons.add(logIn);


        logIn.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try{
            playerDisplayInventoryController.display();
            JOptionPane.showMessageDialog(this, "%s Displayed");
        }catch (Exception e){

        }
    }
}
