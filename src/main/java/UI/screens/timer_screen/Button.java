package UI.screens.timer_screen;

import javax.swing.*;

public class Button {
    static JButton Button;

    public static JButton getButton(){
        return Button;
    }

    public static JButton createButton(String title){
        Button = new JButton(title);
        return Button;
    }
}
