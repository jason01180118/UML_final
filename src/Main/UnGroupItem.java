package Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

public class UnGroupItem extends JMenuItem {

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            Canvas.getInstance().unGroupObject();

        }
    };

    UnGroupItem() {
        setText("UnGroup");
        addMouseListener(mouseAdapter);
    }
}
