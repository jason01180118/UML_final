package Object;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Classes extends BaseObject {
    public Classes(int x, int y) {
        super(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(5, 5, 100, 100);
        g2.drawLine(5, 38, 103, 38);
        g2.drawLine(5, 71, 103, 71);

    }
}
