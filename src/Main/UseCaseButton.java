package Main;

import javax.swing.ImageIcon;

public class UseCaseButton extends Button {
    UseCaseButton() {
        setIcon(new ImageIcon("icon/use_case.jpg"));
        setText("UseCase");
    }

    @Override
    protected void setMode() {
        Canvas.getInstance().setMode(new UseCaseMode());
    }
}
