import java.awt.event.MouseEvent;

public class ObjectMode extends Mode {
    public void mousePressed(MouseEvent me) {
        Canvas.getInstance().add(new Classes(me.getX(), me.getY()));
        Canvas.getInstance().repaint();
    }

    public void mouseReleased(MouseEvent me) {
    }
}
