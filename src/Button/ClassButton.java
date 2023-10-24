package button;

import javax.swing.ImageIcon;

import main.Canvas;
import mode.ClassMode;

public class ClassButton extends Button {
    public ClassButton() {
        setIcon(new ImageIcon(getResource("icon/class.jpg")));
        setText("classes");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new ClassMode());
    }
}
