public class SelectButton extends Button {
    SelectButton() {
        setText("Select");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new SelectMode());
    }
}
