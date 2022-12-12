package use_cases.buy_menu;

import javax.swing.event.ListSelectionEvent;

public interface BuyMenuListInterface {
    /**
     * The interface of the buy menu list that is used to get the index of the selected shop item.
     *
     * @param e the event that characterizes the change.
     */
    void valueChanged(ListSelectionEvent e);
}
