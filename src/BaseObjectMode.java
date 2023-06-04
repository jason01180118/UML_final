import java.awt.event.MouseEvent;

public abstract class BaseObjectMode extends Mode {

    protected AllObject obj = null;
    private final int layer = 0;

    public void mousePressed(MouseEvent me) {
        setClass(me.getX(), me.getY());
        Canvas.getInstance().addComponent(obj, layer);
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void setClass(int x, int y) {
    }
}
