import java.awt.Component;
import java.awt.Point;
import java.awt.geom.Point2D;

public class BaseObject extends AllObject {

    final int WIDTH = 110;
    final int HEIGHT = 110;

    BaseObject(int x, int y) {
        this.x = x;
        this.y = y;
        absoluteX = x;
        absoluteY = y;
        setBounds(x, y, WIDTH, HEIGHT);
        add(new Port(0, HEIGHT / 2));
        add(new Port(WIDTH / 2, 0));
        add(new Port(WIDTH / 2, HEIGHT - Port.HEIGHT));
        add(new Port(WIDTH - Port.WIDTH, HEIGHT / 2));
    }

    @Override
    protected Port getPort(Point point) {
        Port result = null;
        double minDistance = Double.MAX_VALUE;
        for (Component component : getComponents()) {
            Port port = (Port) component;
            double distance = Point2D.distance(point.x - getX(), point.y - getY(), port.getX(), port.getY());
            if (minDistance > distance) {
                result = port;
                minDistance = distance;
            }
        }
        return result;
    }

    @Override
    protected void setSelect() {
        selected = true;
        setPortVisible();
    }

    @Override
    protected void setUnSelect() {
        selected = false;
        setPortVisible();

    }

    @Override
    protected void moveXY(int offsetX, int offsetY) {
        x = x + offsetX;
        y = y + offsetY;
        changeAbsoluteXY(offsetX, offsetY);
        setLocation(x, y);
    }

    @Override
    protected void changeAbsoluteXY(int offsetX, int offsetY) {
        absoluteX = absoluteX + offsetX;
        absoluteY = absoluteY + offsetY;
    }

    @Override
    protected void repaintLine() {
        Canvas.getInstance().repaintLine(this);
    }

    private void setPortVisible() {
        for (Component component : getComponents()) {
            ((Port) component).setVisible(selected);
        }
    }

}
