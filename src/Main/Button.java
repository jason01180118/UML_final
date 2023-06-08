package Main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Button extends JLabel {

    Button() {
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setWhite();
    }

    public void setWhite() {
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }

    public void setBlack() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        repaint();
    }

    protected void setMode() {
    }
}
