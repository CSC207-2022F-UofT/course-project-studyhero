package UI.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button implements ActionListener {
    static JButton Button;

    public static JButton getButton(){
        return Button;
    }

    public static JButton createButton(String title,  ActionListener Listener){
        Button = new JButton(title);
        Button.addActionListener(Listener);
        return getButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
