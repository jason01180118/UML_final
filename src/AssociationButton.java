public class AssociationButton extends Button {
    AssociationButton() {
        setText("AssociationButton");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new AssociationMode());
    }
}
