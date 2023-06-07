import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ToolMenu extends JMenuBar {

    private MouseAdapter groupPressAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            Canvas.getInstance().groupObject();

        }
    };

    private MouseAdapter unGroupPressAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            Canvas.getInstance().unGroupObject();

        }
    };

    ToolMenu() {
        super();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Edit");
        add(m1);
        add(m2);
        JMenuItem m11 = new JMenuItem("Group");
        JMenuItem m22 = new JMenuItem("UnGroup");
        JMenuItem m33 = new JMenuItem("SetName");
        m2.add(m11);
        m2.add(m22);
        m2.add(m33);

        m11.addMouseListener(groupPressAdapter);
        m22.addMouseListener(unGroupPressAdapter);

    }

}
