import java.awt.event.MouseEvent;

public class ConnectionLineMode extends Mode {

    private AllObject startObject = null;
    private AllObject endObject = null;
    private Port startPort = null;
    private Port endPort = null;

    protected AllObject obj = null;
    private final int layer = -1;

    public void mousePressed(MouseEvent me) {
        if (Canvas.getInstance().findComponentAt(me.getPoint()) != Canvas.getInstance()) {
            startObject = (AllObject) Canvas.getInstance().findComponentAt(me.getPoint());
            startPort = startObject.getPort(me.getPoint());
        }
        System.out.println(startObject);

    }

    public void mouseReleased(MouseEvent me) {
        if (Canvas.getInstance().findComponentAt(me.getPoint()) != Canvas.getInstance()) {
            endObject = (AllObject) Canvas.getInstance().findComponentAt(me.getPoint());
            endPort = endObject.getPort(me.getPoint());
        }
        if (startObject != endObject && startObject != null && endObject != null) {
            setClass(startObject.getX() + startPort.getX(), startObject.getY() + startPort.getY(),
                    endObject.getX() + endPort.getX(), endObject.getY() + endPort.getY());
            Canvas.getInstance().addComponent(obj, layer);
            System.out.println("createline");
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
