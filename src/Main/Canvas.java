package Main;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;

import Mode.Mode;
import Object.AllObject;
import Object.Composite;

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

    public void setMode(Mode m) {
        removeMouseListener(mode);
        removeMouseMotionListener(mode);
        mode = m;
        addMouseListener(mode);
        addMouseMotionListener(mode);
    }

    public void addComponent(AllObject obj, int order, int layer) {
        add(obj, order);
        setLayer(obj, layer);
        repaint();
    }

    public AllObject getObjectAt(Point p) {
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

    public void setUnSelect() {
        for (Component component : getComponentsInLayer(1)) {
            ((AllObject) component).setUnSelect();
        }
    }

    public int countSelected() {
        int count = 0;
        for (Component component : getComponentsInLayer(1)) {
            if (((AllObject) component).selected) {
                count++;
            }
        }
        return count;
    }

    public void setSelectArea(Point startPoint, Point endPoint) {
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

    public void moveSelectedObj(int offsetX, int offsetY) {
        for (Component component : getComponentsInLayer(1)) {
            if (((AllObject) component).selected) {
                ((AllObject) component).moveXY(offsetX, offsetY);
                ((AllObject) component).repaintLine();
            }
        }
    }

    public void repaintLine(AllObject obj) {
        for (Component component : getComponentsInLayer(0)) {
            if (((AllObject) component).isRelated(obj)) {
                ((AllObject) component).setXY();
            }
        }
    }

    public void groupObject() {
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
            addComponent(compositeObj, 0, 1);
        }
    }

    public void unGroupObject() {
        if (countSelected() == 1) {
            for (Component component : getComponentsInLayer(1)) {

                if (((AllObject) component).selected) {
                    if (((AllObject) component).setUnGroup()) {
                        remove(component);
                    }

                }
            }
        }
    }

    public void changeName(String name) {
        if (countSelected() == 1) {
            for (Component component : getComponentsInLayer(1)) {

                if (((AllObject) component).selected) {
                    ((AllObject) component).changeName(name);

                }
            }
        }
    }

}
