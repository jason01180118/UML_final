package Main;

import java.awt.Color;

import javax.swing.BorderFactory;
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
