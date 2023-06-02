public class UseCaseButton extends Button {
    UseCaseButton() {
        setText("UseCase");
    }

    protected void setMode() {
        Canvas.getInstance().setMode(new UseCaseMode());
    }
}
