public class ClassButton extends Button {
    ClassButton() {
        setText("classes");
    }

    protected void setMode() {
        Canvas.getInstance().setMode(new ObjectMode());
    }
}
