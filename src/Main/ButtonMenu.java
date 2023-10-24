package main;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import button.AssociationButton;
import button.Button;
import button.ClassButton;
import button.CompositionButton;
import button.GeneralizationButton;
import button.SelectButton;
import button.UseCaseButton;

public class ButtonMenu extends JPanel {

    MouseAdapter clickEvent = new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            Canvas.getInstance().setUnSelect();
            setBtnWhite();
            ((Button) getComponentAt(me.getPoint())).setBlack();
            ((Button) getComponentAt(me.getPoint())).setMode();
        }

    };

    public ButtonMenu() {
        setLayout(new GridLayout(6, 1));
        add(new ClassButton());
        add(new UseCaseButton());
        add(new AssociationButton());
        add(new CompositionButton());
        add(new GeneralizationButton());
        add(new SelectButton());
        addMouseListener(clickEvent);
    }

    protected void setBtnWhite() {
        for (Component btn : getComponents()) {
            ((Button) btn).setWhite();
        }
    }
}
