package button;

import javax.swing.ImageIcon;

import main.Canvas;
import mode.SelectMode;

public class SelectButton extends Button {
    public SelectButton() {
        setIcon(new ImageIcon(getResource("icon/select.jpg")));
        setText("Select");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new SelectMode());
    }
}
