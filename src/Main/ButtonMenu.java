package Main;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

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
