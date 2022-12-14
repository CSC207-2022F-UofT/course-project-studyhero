
package errors.usecases;

import javax.swing.*;

public class ErrorWindow extends JFrame{

    /**
     * Creates a new ErrorWindow (JFrame object) displaying an
     * error message.
     *
     * @param error     error message
     */
    public ErrorWindow(String error){
        this.setTitle("Error");
        JLabel errorLabel = new JLabel(error);

        this.add(errorLabel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}