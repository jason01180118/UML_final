public class ConnectionLine extends AllObject {

    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected AllObject startObject = null;
    protected AllObject endObject = null;
    protected Port startPort = null;
    protected Port endPort = null;

    ConnectionLine(int x, int y, AllObject startObject, AllObject endObject, Port startPort, Port endPort) {
        super(x, y);
        setBounds(x, y, Canvas.getInstance().getWidth(), Canvas.getInstance().getHeight());
        this.startObject = startObject;
        this.endObject = endObject;
        this.startPort = startPort;
        this.endPort = endPort;
        setXY();
    }

    @Override
    protected void setXY() {
        startX = startObject.getX() + startPort.getX();
        startY = startObject.getY() + startPort.getY();
        endX = endObject.getX() + endPort.getX();
        endY = endObject.getY() + endPort.getY();
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
