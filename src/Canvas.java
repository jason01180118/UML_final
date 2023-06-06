import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;

import javax.sound.sampled.SourceDataLine;
import javax.swing.JLayeredPane;

public class Canvas extends JLayeredPane {
    private volatile static Canvas uniqueInstance;
    Mode mode = null;

    private Canvas() {
    }

    public static Canvas getInstance() {
        if (uniqueInstance == null) {
            synchronized (Canvas.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Canvas();
                }
            }
        }
        return uniqueInstance;
    }

    protected void setMode(Mode m) {
        removeMouseListener(mode);
        removeMouseMotionListener(mode);
        mode = m;
        addMouseListener(mode);
        addMouseMotionListener(mode);
    }

    protected void addComponent(AllObject obj, int layer) {
        System.out.println(getComponentCountInLayer(0));
        System.out.println(getComponentCountInLayer(1));
        add(obj, layer);
        repaint();
    }

    protected void setUnSelect() {
        for (Component component : getComponentsInLayer(1)) {
            ((AllObject) component).setUnSelect();
        }
    }

    protected int countSelected() {
        int count = 0;
        for (Component component : getComponentsInLayer(1)) {
            if (((AllObject) component).selected) {
                count++;
            }
        }
        return count;
    }

    protected void setSelectArea(Point startPoint, Point endPoint) {
        int minX = Math.min(startPoint.x, endPoint.x);
        int maxX = Math.max(startPoint.x, endPoint.x);
        int minY = Math.min(startPoint.y, endPoint.y);
        int maxY = Math.max(startPoint.y, endPoint.y);
        for (Component component : getComponentsInLayer(1)) {
            Rectangle bounds = ((AllObject) component).getBounds();
            if (bounds.x >= minX && maxX >= bounds.x + bounds.width && bounds.y >= minY
                    && maxY >= bounds.y + bounds.height) {
                ((AllObject) component).setSelect();
            }
        }
    }

    protected void moveSelectedObj(int offsetX, int offsetY) {
        for (Component component : getComponentsInLayer(1)) {
            if (((AllObject) component).selected) {
                for (Component insideComponent : getComponentsInLayer(0)) {
                    if (((AllObject) insideComponent).isRelated()) {
                        ((AllObject) component).moveXY(offsetX, offsetY);
                    }
                }
                ((AllObject) component).moveXY(offsetX, offsetY);
            }
        }
    }

}
