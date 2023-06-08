package Mode;

import java.awt.event.MouseEvent;

import Main.Canvas;
import Object.AllObject;

public abstract class BaseObjectMode extends Mode {

    protected AllObject obj = null;
    private final int ORDER = 0;
    private final int LAYER = 1;

    public void mousePressed(MouseEvent me) {
        setClass(me.getX(), me.getY());
        Canvas.getInstance().addComponent(obj, ORDER);
        Canvas.getInstance().setLayer(obj, LAYER);

    }

    public void mouseReleased(MouseEvent me) {
    }

    public void setClass(int x, int y) {
    }
}
