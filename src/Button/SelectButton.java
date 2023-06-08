package Button;

import javax.swing.ImageIcon;

import Main.Canvas;
import Mode.SelectMode;

public class SelectButton extends Button {
    public SelectButton() {
        setIcon(new ImageIcon("icon/select.jpg"));
        setText("Select");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new SelectMode());
    }
}
