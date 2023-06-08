import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

public class GroupItem extends JMenuItem {

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            Canvas.getInstance().groupObject();

        }
    };

    GroupItem() {
        setText("Group");
        addMouseListener(mouseAdapter);
    }
}
