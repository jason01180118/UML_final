package item;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import main.Canvas;

public class UnGroupItem extends JMenuItem {

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            Canvas.getInstance().unGroupObject();

        }
    };

    public UnGroupItem() {
        setText("UnGroup");
        addMouseListener(mouseAdapter);
    }
}
