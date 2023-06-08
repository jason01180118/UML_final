package Main;

public class CompositionButton extends Button {
    CompositionButton() {
        setText("Composition");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new CompositionMode());
    }
}
