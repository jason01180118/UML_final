import java.awt.event.MouseEvent;

public class SelectMode extends Mode {

    AllObject obj = null;

    public void mouseClicked(MouseEvent me) {
        if (Canvas.getInstance().findComponentAt(me.getPoint()) != Canvas.getInstance()) {
            obj = (AllObject) Canvas.getInstance().findComponentAt(me.getPoint());
            obj.setSelect();
        }

    }

    public void mousePressed(MouseEvent me) {
        Canvas.getInstance().setUnSelect();
    }

    public void mouseReleased(MouseEvent me) {
    }
}
