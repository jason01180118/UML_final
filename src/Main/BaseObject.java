package Main;

import java.awt.Component;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BaseObject extends AllObject {

    final int WIDTH = 110;
    final int HEIGHT = 110;

    private ArrayList<Port> ports = new ArrayList<>();
    private JLabel nameLabel = new JLabel("name", SwingConstants.CENTER);

    BaseObject(int x, int y) {
        this.x = x;
        this.y = y;
        absoluteX = x;
        absoluteY = y;
        setBounds(x, y, WIDTH, HEIGHT);
        initPorts();
        nameLabel.setBounds(5, 5, 100, 100);
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
    protected Port getPort(Point point) {
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
    protected void repaintLine() {
        Canvas.getInstance().repaintLine(this);
    }

    private void setPortVisible() {
        for (Port port : ports) {
            port.setVisible(selected);
        }
    }

    @Override
    protected void changeName(String name) {
        nameLabel.setText(name);
    }

}
