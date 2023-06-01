import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ButtonMenu extends JPanel {

    private volatile static ButtonMenu uniqueInstance;

    private ArrayList<Button> buttons = new ArrayList<>();

    private ButtonMenu() {
        setLayout(new GridLayout(6, 1));
        buttons.add(new ClassButton());
        initButtons();
    }

    public static ButtonMenu getInstance() {
        if (uniqueInstance == null) {
            synchronized (ButtonMenu.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ButtonMenu();
                }
            }
        }
        return uniqueInstance;
    }

    protected void setBtnWhite() {
        for (Button btn : buttons) {
            btn.setWhite();
        }
    }

    private void initButtons() {
        for (Button btn : buttons) {
            add(btn);
        }
    }
}
