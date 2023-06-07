import java.awt.Point;

import javax.swing.JPanel;

public abstract class AllObject extends JPanel {

    protected boolean selected = false;
    int x;
    int y;

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

    protected void setXY() {
    }

    protected boolean isRelated(AllObject obj) {
        return false;
    }
}
