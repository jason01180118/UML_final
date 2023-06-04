import java.awt.Point;

import javax.swing.JPanel;

public class AllObject extends JPanel {
    AllObject() {
        setLayout(null);
        setOpaque(false);
    }

    protected Port getPort(Point p) {
        return null;
    }
}
