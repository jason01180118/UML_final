import java.awt.Point;

import javax.swing.JPanel;

public abstract class AllObject extends JPanel {

    protected boolean selected = false;
    protected int x;
    protected int y;
    protected int absoluteX;
    protected int absoluteY;

    AllObject() {
        setLayout(null);
        setOpaque(false);
    }

    protected Port getPort(Point p) {
        return null;
    }

    protected void setSelect() {

    }

    protected void setUnSelect() {

    }

    protected void moveXY(int offsetX, int offsetY) {

    }

    protected void changeXY(int changeX, int changeY) {
        x = changeX;
        y = changeY;
        setLocation(x, y);
    }

    protected void changeAbsoluteXY(int offsetX, int offsetY) {

    }

    protected void setXY() {
    }

    protected boolean isRelated(AllObject obj) {
        return false;
    }

    protected void repaintLine() {

    }

    protected void setUnGroup() {

    }
}
