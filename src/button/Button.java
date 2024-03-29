package button;

import java.awt.Color;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class Button extends JLabel {

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

    public void setMode() {
    }

    protected URL getResource(String fileName) {
        return Button.class.getResource(fileName);
    }
}
