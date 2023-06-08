package Item;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Main.Canvas;

public class SetNameItem extends JMenuItem {

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            setNewName();

        }
    };

    public SetNameItem() {
        setText("SetName");
        addMouseListener(mouseAdapter);
    }

    private void setNewName() {
        JFrame setNameFrame = new JFrame();

        String getMessage = JOptionPane.showInputDialog(setNameFrame, "Enter your message");

        if (getMessage != null) {
            Canvas.getInstance().changeName(getMessage);
        }

    }
}
