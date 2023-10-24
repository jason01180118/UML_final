package button;

import javax.swing.ImageIcon;

import main.Canvas;
import mode.AssociationMode;

public class AssociationButton extends Button {
    public AssociationButton() {
        setIcon(new ImageIcon(getResource("icon/association_line.jpg")));
        setText("AssociationButton");

    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new AssociationMode());
    }
}
