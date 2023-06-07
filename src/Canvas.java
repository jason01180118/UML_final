import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;

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
        System.out.println(getComponentCount());
        System.out.println(getComponentCountInLayer(0));
        System.out.println(getComponentCountInLayer(1));
        add(obj, layer);
        repaint();
    }

    protected AllObject getObjectAt(Point p) {
        AllObject returnObj = null;
        for (Component component : getComponentsInLayer(1)) {
            Rectangle bounds = ((AllObject) component).getBounds();
            if (bounds.x <= p.x && bounds.x + bounds.width >= p.x && bounds.y <= p.y
                    && bounds.y + bounds.height >= p.y) {
                returnObj = (AllObject) component;
            }
        }
        return returnObj;
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
                ((AllObject) component).moveXY(offsetX, offsetY);
                ((AllObject) component).repaintLine();
            }
        }
    }

    protected void repaintLine(AllObject obj) {
        for (Component component : getComponentsInLayer(0)) {
            if (((AllObject) component).isRelated(obj)) {
                ((AllObject) component).setXY();
            }
        }
    }

    protected void groupObject() {
        if (countSelected() > 1) {
            AllObject compositeObj = new Composite();
            for (Component component : getComponentsInLayer(1)) {

                if (((AllObject) component).selected) {
                    ((AllObject) component).setUnSelect();
                    compositeObj.add(component);
                    remove(component);

                }
            }
            compositeObj.setXY();
            addComponent(compositeObj, 0);
            setLayer(compositeObj, 1);
        }
    }

    protected void unGroupObject() {
        if (countSelected() == 1) {
            for (Component component : getComponentsInLayer(1)) {

                if (((AllObject) component).selected) {
                    ((AllObject) component).setUnGroup();
                    remove(component);
                }
            }
        }
    }

}
