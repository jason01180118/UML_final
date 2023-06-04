import java.awt.event.MouseEvent;

public class ConnectionLineMode extends Mode {
    public void mousePressed(MouseEvent me) {
        System.out.println(Canvas.getInstance().findComponentAt(me.getPoint()));

    }

    public void mouseReleased(MouseEvent me) {
        System.out.println(Canvas.getInstance().findComponentAt(me.getPoint()));
    }
}
