import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    private volatile static Canvas uniqueInstance;
    Mode mode = null;
    private ArrayList<AllObject> Objects = new ArrayList<>();

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

    protected void addComponent(AllObject obj) {
        Objects.add(obj);
        add(obj);
        repaint();
    }

}
