import java.awt.Point;
import java.awt.event.MouseEvent;

public class SelectMode extends Mode {

    private AllObject obj = null;
    private Point startPoint = null;
    private Point endPoint = null;
    private Point buffer = null;

    @Override
    public void mousePressed(MouseEvent me) {

        if (Canvas.getInstance().findComponentAt(me.getPoint()) != Canvas.getInstance()) {
            obj = (AllObject) Canvas.getInstance().findComponentAt(me.getPoint());
            System.out.println(obj.selected);
            if (!obj.selected) {
                Canvas.getInstance().setUnSelect();
                obj.setSelect();
            }
        } else {
            Canvas.getInstance().setUnSelect();
        }
        startPoint = me.getPoint();
        buffer = me.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        System.out.println("drag");
        if (Canvas.getInstance().countSelected() != 0) {
            System.out.println(me.getPoint().x - buffer.x);
            System.out.println(me.getPoint().y - buffer.y);
            // Canvas.getInstance().moveSelectedObj(me.getPoint().x-buffer.x,me.getPoint().y-buffer.y);
            buffer = me.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("release");
        endPoint = me.getPoint();
        if (Canvas.getInstance().countSelected() == 0) {
            Canvas.getInstance().setSelectArea(startPoint, endPoint);
        }
    }
}
