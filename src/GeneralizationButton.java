public class GeneralizationButton extends Button {
    GeneralizationButton() {
        setText("Generalization");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(null);
    }
}