package Main;

import javax.swing.ImageIcon;

public class SelectButton extends Button {
    SelectButton() {
        setIcon(new ImageIcon("icon/select.jpg"));
        setText("Select");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new SelectMode());
    }
}
