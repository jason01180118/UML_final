package Main;

import javax.swing.ImageIcon;

public class GeneralizationButton extends Button {
    GeneralizationButton() {
        setIcon(new ImageIcon("icon/generalization_line.jpg"));
        setText("Generalization");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new GeneralizationMode());
    }
}
