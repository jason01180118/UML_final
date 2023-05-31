import javax.swing.JPanel;

public class Canvas extends JPanel {
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

    protected void printTest() {
        System.out.println("123");
    }

}
