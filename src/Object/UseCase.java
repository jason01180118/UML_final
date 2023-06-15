package Object;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UseCase extends BaseObject {
    public UseCase(int x, int y) {
        super(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(STROKE));
        g2.drawOval(Port.WIDTH, Port.HEIGHT, WIDTH - 2 * Port.WIDTH, HEIGHT - 2 * Port.HEIGHT);

    }
}
