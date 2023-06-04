import java.awt.Point;

import javax.swing.JPanel;

public abstract class AllObject extends JPanel {

    protected boolean selected = false;

    AllObject() {
        setLayout(null);
        setOpaque(false);
    }

    protected Port getPort(Point p) {
        return null;
    }

    protected void setSelect() {

    }

    protected void setUnSelect() {

    }
}
