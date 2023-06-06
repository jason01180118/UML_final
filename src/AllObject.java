import java.awt.Point;

import javax.swing.JPanel;

public abstract class AllObject extends JPanel {

    protected boolean selected = false;
    int x;
    int y;

    AllObject(int x, int y) {
        this.x = x;
        this.y = y;
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

    protected boolean isRelated() {
        return false;
    }
}
