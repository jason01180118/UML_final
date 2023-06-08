package Object;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class GeneralizationLine extends ConnectionLine {
    public GeneralizationLine(AllObject startObject, AllObject endObject, Port startPort, Port endPort) {
        super(startObject, endObject, startPort, endPort);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        double rotateX = (Math.cos(Math.PI / 4) * (startX - endX) - Math.sin(Math.PI / 4) * (startY - endY));
        double rotateY = (Math.sin(Math.PI / 4) * (startX - endX) + Math.cos(Math.PI / 4) * (startY - endY));
        double distance = Point2D.distance(0, 0, rotateX, rotateY);
        rotateX = rotateX / distance * 20;
        rotateY = rotateY / distance * 20;
        g2.drawLine((int) (rotateX + endX), (int) (rotateY + endY), endX, endY);
        double rotateX2 = (Math.cos(-1 * Math.PI / 4) * (startX - endX) - Math.sin(-1 * Math.PI / 4) * (startY - endY));
        double rotateY2 = (Math.sin(-1 * Math.PI / 4) * (startX - endX) + Math.cos(-1 * Math.PI / 4) * (startY - endY));
        rotateX2 = rotateX2 / distance * 20;
        rotateY2 = rotateY2 / distance * 20;
        g2.drawLine((int) (rotateX2 + endX), (int) (rotateY2) + endY, endX, endY);
        g2.drawLine((int) (rotateX2 + endX), (int) (rotateY2 + endY), (int) (rotateX + endX), (int) (rotateY + endY));
        g2.drawLine(startX, startY, (int) ((rotateX + rotateX2) / 2 + endX), (int) ((rotateY + rotateY2) / 2 + endY));

    }
}
