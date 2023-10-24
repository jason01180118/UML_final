package button;

import javax.swing.ImageIcon;

import main.Canvas;
import mode.UseCaseMode;

public class UseCaseButton extends Button {
    public UseCaseButton() {
        setIcon(new ImageIcon(getResource("icon/use_case.jpg")));
        setText("UseCase");
    }

    @Override
    public void setMode() {
        Canvas.getInstance().setMode(new UseCaseMode());
    }
}
