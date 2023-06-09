package Mode;

import java.awt.event.MouseEvent;

import Main.Canvas;
import Object.AllObject;
import Object.Port;

public class ConnectionLineMode extends Mode {

    protected AllObject startObject = null;
    protected AllObject endObject = null;
    protected Port startPort = null;
    protected Port endPort = null;

    protected AllObject obj = null;
    private final int ORDER = 0;
    private final int LAYER = 0;

    public void mousePressed(MouseEvent me) {
        startObject = Canvas.getInstance().getObjectAt(me.getPoint());
        if (startObject != null) {
            startPort = startObject.getPort(me.getPoint());
        }

    }

    public void mouseReleased(MouseEvent me) {
        endObject = Canvas.getInstance().getObjectAt(me.getPoint());
        if (endObject != null) {
            endPort = endObject.getPort(me.getPoint());
        }

        if (startObject != endObject && startPort != null && endPort != null) {
            setClass();
            Canvas.getInstance().addComponent(obj, ORDER, LAYER);
        }
        reset();
    }

    private void reset() {
        startObject = null;
        endObject = null;
        startPort = null;
        endPort = null;
    }

    public void setClass() {
    }
}
