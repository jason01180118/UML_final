import java.awt.Component;
import javax.swing.JLayeredPane;

public class Canvas extends JLayeredPane {
    private volatile static Canvas uniqueInstance;
    Mode mode = null;

    private Canvas() {
    }

    public static Canvas getInstance() {
        if (uniqueInstance == null) {
            synchronized (Canvas.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Canvas();
                }
            }
        }
        return uniqueInstance;
    }

    protected void setMode(Mode m) {
        removeMouseListener(mode);
        mode = m;
        addMouseListener(mode);
    }

    protected void addComponent(AllObject obj, int layer) {
        System.out.println(getComponentCountInLayer(0));
        System.out.println(getComponentCountInLayer(1));
        add(obj, layer);
        repaint();
    }

    protected void setUnSelect() {
        for (Component component : getComponentsInLayer(1)) {
            ((AllObject) component).setUnSelect();
        }
    }

}
