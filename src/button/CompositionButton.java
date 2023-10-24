package button;

import javax.swing.ImageIcon;

import main.Canvas;
import mode.CompositionMode;

public class CompositionButton extends Button {
    public CompositionButton() {
        setIcon(new ImageIcon(getResource("icon/composition_line.jpg")));
        setText("Composition");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new CompositionMode());
    }
}
