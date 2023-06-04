public class ConnectionLine extends AllObject {

    int startX;
    int startY;
    int endX;
    int endY;

    ConnectionLine(int startX, int startY, int endX, int endY) {
        setBounds(0, 0, Canvas.getInstance().getWidth(), Canvas.getInstance().getHeight());
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}
