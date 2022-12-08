package shopmenu.buymenu;

import use_cases.errors.ErrorOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyItemController implements ActionListener {

    CardLayout card;
    JPanel parentPanel;
    JFrame parentFrame;
    private BuyItemInputBoundary useCase;
    final ErrorOutputBoundary presenter;

    public BuyItemController(CardLayout card, JPanel parentPanel,
                             JFrame parentFrame, BuyItemInputBoundary buyItemUseCase,
                             ErrorOutputBoundary presenter) {
        this.card = card;
        this.parentPanel = parentPanel;
        this.parentFrame = parentFrame;
        this.useCase = buyItemUseCase;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // todo
    }

}
