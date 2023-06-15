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
        g2.setStroke(new BasicStroke(STROKE));
        g2.drawRect(Port.WIDTH, Port.HEIGHT, WIDTH - 2 * Port.WIDTH, HEIGHT - 2 * Port.HEIGHT);
        g2.drawLine(Port.WIDTH, HEIGHT / 3, WIDTH - 2 * (Port.WIDTH - STROKE),
                HEIGHT / 3);
        g2.drawLine(Port.WIDTH, HEIGHT / 3 * 2, WIDTH - 2 * (Port.WIDTH - STROKE),
                HEIGHT / 3 * 2);

    }
}
