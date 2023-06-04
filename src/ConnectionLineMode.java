import java.awt.event.MouseEvent;

public class ConnectionLineMode extends Mode {

    private AllObject startObject = null;
    private AllObject endObject = null;
    private Port startPort = null;
    private Port endPort = null;

    protected AllObject obj = null;
    private final int ORDER = 0;
    private final int LAYER = 0;

    public void mousePressed(MouseEvent me) {
        if (Canvas.getInstance().findComponentAt(me.getPoint()) != Canvas.getInstance()) {
            startObject = (AllObject) Canvas.getInstance().findComponentAt(me.getPoint());
            startPort = startObject.getPort(me.getPoint());
        }

    }

    public void mouseReleased(MouseEvent me) {
        if (Canvas.getInstance().findComponentAt(me.getPoint()) != Canvas.getInstance()) {
            endObject = (AllObject) Canvas.getInstance().findComponentAt(me.getPoint());
            endPort = endObject.getPort(me.getPoint());
        }
        if (startObject != endObject && startObject != null && endObject != null) {
            setClass(startObject.getX() + startPort.getX(), startObject.getY() + startPort.getY(),
                    endObject.getX() + endPort.getX(), endObject.getY() + endPort.getY());
            Canvas.getInstance().addComponent(obj, ORDER);
            Canvas.getInstance().setLayer(obj, LAYER);
        }
        reset();
    }

    private void reset() {
        startObject = null;
        endObject = null;
        startPort = null;
        endPort = null;
    }

    public void setClass(int startX, int startY, int endX, int endY) {
    }
}
