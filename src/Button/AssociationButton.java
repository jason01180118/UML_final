package Button;

import javax.swing.ImageIcon;

import Main.Canvas;
import Mode.AssociationMode;

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
