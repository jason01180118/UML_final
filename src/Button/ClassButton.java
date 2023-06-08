package Button;

import javax.swing.ImageIcon;

import Main.Canvas;
import Mode.ClassMode;

public class ClassButton extends Button {
    public ClassButton() {
        setIcon(new ImageIcon("icon/class.jpg"));
        setText("classes");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new ClassMode());
    }
}
