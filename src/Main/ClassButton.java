package Main;

import javax.swing.ImageIcon;

public class ClassButton extends Button {
    ClassButton() {
        setIcon(new ImageIcon("icon/class.jpg"));
        setText("classes");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new ClassMode());
    }
}
