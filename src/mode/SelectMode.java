package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import main.Canvas;
import object.AllObject;

public class SelectMode extends Mode {

    private AllObject obj = null;
    private Point startPoint = null;
    private Point endPoint = null;
    private Point buffer = null;

    @Override
    public void mousePressed(MouseEvent me) {

        obj = Canvas.getInstance().getObjectAt(me.getPoint());
        if (obj != null) {

            System.out.println(obj);
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
        if (Canvas.getInstance().countSelected() != 0) {
            Canvas.getInstance().moveSelectedObj(me.getPoint().x - buffer.x, me.getPoint().y - buffer.y);
            buffer = me.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        endPoint = me.getPoint();
        if (Canvas.getInstance().countSelected() == 0) {
            Canvas.getInstance().setSelectArea(startPoint, endPoint);
        }
    }
}
