
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Button extends JButton {

    MouseAdapter clickEvent = new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            ButtonMenu.getInstance().setBtnWhite();
            setBlack();
            setMode();
        }

    };

    Button() {
        addMouseListener(clickEvent);
    }

    public void setWhite() {
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }

    public void setBlack() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }

    protected void setMode() {
        Canvas.getInstance().setMode(null);
    }
}
