import java.awt.event.MouseEvent;

public abstract class BaseObjectMode extends Mode {

    AllObject obj = null;

    public void mousePressed(MouseEvent me) {
        setClass(me.getX(), me.getY());
        Canvas.getInstance().addComponent(obj);
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void setClass(int x, int y) {
    }
}
