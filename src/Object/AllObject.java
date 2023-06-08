package Object;

import java.awt.Point;

import javax.swing.JPanel;

public abstract class AllObject extends JPanel {

    public boolean selected = false;
    protected int x;
    protected int y;
    protected int absoluteX;
    protected int absoluteY;

    AllObject() {
        setLayout(null);
        setOpaque(false);
    }

    public Port getPort(Point p) {
        return null;
    }

    public void setSelect() {

    }

    public void setUnSelect() {

    }

    public void moveXY(int offsetX, int offsetY) {

    }

    protected void changeXY(int changeX, int changeY) {

    }

    protected void changeAbsoluteXY(int offsetX, int offsetY) {

    }

    public void setXY() {
    }

    public boolean isRelated(AllObject obj) {
        return false;
    }

    public void repaintLine() {

    }

    public boolean setUnGroup() {
        return false;
    }

    public void changeName(String name) {
    }
}
