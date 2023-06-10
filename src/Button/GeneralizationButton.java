package Button;

import javax.swing.ImageIcon;

import Main.Canvas;
import Mode.GeneralizationMode;

public class GeneralizationButton extends Button {
    public GeneralizationButton() {
        setIcon(new ImageIcon(getResource("icon/generalization_line.jpg")));
        setText("Generalization");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new GeneralizationMode());
    }
}
