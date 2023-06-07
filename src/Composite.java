import java.awt.Component;
import java.awt.Rectangle;

public class Composite extends AllObject {

    protected int startX = Integer.MAX_VALUE;
    protected int startY = Integer.MAX_VALUE;
    protected int endX = Integer.MIN_VALUE;
    protected int endY = Integer.MIN_VALUE;

    Composite() {
    }

    @Override
    protected void setSelect() {
        selected = true;
    }

    @Override
    protected void setUnSelect() {
        selected = false;

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
        for (Component component : getComponents()) {
            ((AllObject) component).changeAbsoluteXY(offsetX, offsetY);
        }
    }

    @Override
    protected void setXY() {
        for (Component component : getComponents()) {
            Rectangle bounds = ((AllObject) component).getBounds();
            startX = Math.min(startX, bounds.x);
            startY = Math.min(startY, bounds.y);
            endX = Math.max(endX, bounds.x + bounds.width);
            endY = Math.max(endY, bounds.y + bounds.height);
        }
        x = startX;
        y = startY;
        absoluteX = x;
        absoluteY = y;
        setBounds(startX, startY, endX - startX, endY - startY);
        for (Component component : getComponents()) {
            ((AllObject) component).changeXY(component.getX() - x, component.getY() - y);
        }
        repaint();
    }

    @Override
    protected void repaintLine() {
        for (Component component : getComponents()) {
            ((AllObject) component).repaintLine();
        }
    }

    @Override
    protected void setUnGroup() {
        for (Component component : getComponents()) {
            ((AllObject) component).changeXY(component.getX() + x, component.getY() + y);
            Canvas.getInstance().addComponent(((AllObject) component), 1);
        }
    }
}
