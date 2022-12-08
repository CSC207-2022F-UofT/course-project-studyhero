
package use_cases.errors;

import javax.swing.*;

public class ErrorWindow{
    public ErrorWindow(String error){
        JFrame errorWindow = new JFrame("Error");
        JPanel errorPanel = new JPanel();
        JLabel errorLabel = new JLabel(error);

        errorPanel.add(errorLabel);
        errorWindow.add(errorPanel);
        errorWindow.pack();
        errorWindow.getDefaultCloseOperation();
        errorWindow.setVisible(true);
    }
}