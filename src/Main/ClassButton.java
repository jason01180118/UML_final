package Main;

public class ClassButton extends Button {
    ClassButton() {
        setText("classes");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new ClassMode());
    }
}
