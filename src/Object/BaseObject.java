package Object;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.Canvas;

public abstract class BaseObject extends AllObject {

    final int WIDTH = 110;
    final int HEIGHT = 110;
    final int STROKE = 2;

    private ArrayList<Port> ports = new ArrayList<>();
    private JLabel nameLabel = new JLabel("name", SwingConstants.CENTER);

    BaseObject(int x, int y) {
        this.x = x;
        this.y = y;
        absoluteX = x;
        absoluteY = y;
        setBounds(x, y, WIDTH, HEIGHT);
        initPorts();
        nameLabel.setBounds(Port.WIDTH, Port.HEIGHT, WIDTH - Port.WIDTH, HEIGHT - Port.HEIGHT);
        add(nameLabel);
    }

    private void initPorts() {
        ports.add(new Port(0, HEIGHT / 2));
        ports.add(new Port(WIDTH / 2, 0));
        ports.add(new Port(WIDTH / 2, HEIGHT - Port.HEIGHT));
        ports.add(new Port(WIDTH - Port.WIDTH, HEIGHT / 2));
        for (Port port : ports) {
            add(port);
        }
    }

    @Override
    public Port getPort(Point point) {
        Port result = null;
        double minDistance = Double.MAX_VALUE;
        for (Port port : ports) {
            double distance = Point2D.distance(point.x - getX(), point.y - getY(), port.getX(), port.getY());
            if (minDistance > distance) {
                result = port;
                minDistance = distance;
            }
        }
        return result;
    }

    @Override
    public void setSelect() {
        selected = true;
        setPortVisible();
    }

    @Override
    public void setUnSelect() {
        selected = false;
        setPortVisible();

    }

    @Override
    public void moveXY(int offsetX, int offsetY) {
        x = x + offsetX;
        y = y + offsetY;
        changeAbsoluteXY(offsetX, offsetY);
        setLocation(x, y);
    }

    @Override
    protected void changeXY(int changeX, int changeY) {
        x = changeX;
        y = changeY;
        setLocation(x, y);
    }

    @Override
    protected void changeAbsoluteXY(int offsetX, int offsetY) {
        absoluteX = absoluteX + offsetX;
        absoluteY = absoluteY + offsetY;
    }

    @Override
    public void repaintLine() {
        Canvas.getInstance().repaintLine(this);
    }

    private void setPortVisible() {
        for (Port port : ports) {
            port.setVisible(selected);
        }
    }

    @Override
    public void changeName(String name) {
        nameLabel.setText(name);
    }

}
