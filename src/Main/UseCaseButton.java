package Main;

public class UseCaseButton extends Button {
    UseCaseButton() {
        setText("UseCase");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new UseCaseMode());
    }
}
