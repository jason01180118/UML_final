package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class Port extends JLabel {

    static final int WIDTH = 5;
    static final int HEIGHT = 5;

    Port(int x, int y) {
        setBounds(x, y, WIDTH, HEIGHT);
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

    }
}
