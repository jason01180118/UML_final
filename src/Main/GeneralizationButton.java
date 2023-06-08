package Main;

public class GeneralizationButton extends Button {
    GeneralizationButton() {
        setText("Generalization");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new GeneralizationMode());
    }
}
