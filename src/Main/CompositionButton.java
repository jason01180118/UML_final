package Main;

import javax.swing.ImageIcon;

public class CompositionButton extends Button {
    CompositionButton() {
        setIcon(new ImageIcon("icon/composition_line.jpg"));
        setText("Composition");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new CompositionMode());
    }
}
