package Main;

import javax.swing.ImageIcon;

public class AssociationButton extends Button {
    AssociationButton() {
        setIcon(new ImageIcon("icon/select.jpg"));
        setText("AssociationButton");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new AssociationMode());
    }
}
