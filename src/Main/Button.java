package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Button extends JLabel {

    Button() {
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
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
