package Button;

import javax.swing.ImageIcon;

import Main.Canvas;
import Mode.CompositionMode;

public class CompositionButton extends Button {
    public CompositionButton() {
        setIcon(new ImageIcon("icon/composition_line.jpg"));
        setText("Composition");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new CompositionMode());
    }
}
