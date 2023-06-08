package Main;

public class ConnectionLine extends AllObject {

    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected AllObject startObject = null;
    protected AllObject endObject = null;
    protected Port startPort = null;
    protected Port endPort = null;

    ConnectionLine(AllObject startObject, AllObject endObject, Port startPort, Port endPort) {
        x = 0;
        y = 0;
        setBounds(x, y, Canvas.getInstance().getWidth(), Canvas.getInstance().getHeight());
        this.startObject = startObject;
        this.endObject = endObject;
        this.startPort = startPort;
        this.endPort = endPort;
        setXY();
    }

    @Override
    protected void setXY() {
        startX = startObject.absoluteX + startPort.getX();
        startY = startObject.absoluteY + startPort.getY();
        endX = endObject.absoluteX + endPort.getX();
        endY = endObject.absoluteY + endPort.getY();
        repaint();
    }

    @Override
    protected boolean isRelated(AllObject obj) {
        if (startObject == obj || endObject == obj) {
            return true;
        }
        return false;
    }
}