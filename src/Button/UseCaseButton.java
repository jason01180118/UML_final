package Button;

import javax.swing.ImageIcon;

import Main.Canvas;
import Mode.UseCaseMode;

public class UseCaseButton extends Button {
    public UseCaseButton() {
        setIcon(new ImageIcon("icon/use_case.jpg"));
        setText("UseCase");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new UseCaseMode());
    }
}
