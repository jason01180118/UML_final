import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ButtonMenu extends JPanel {

    private volatile static ButtonMenu uniqueInstance;

    private ButtonMenu() {
        setLayout(new GridLayout(6, 1));
        add(new ClassButton());
        add(new UseCaseButton());
        add(new AssociationButton());
        add(new CompositionButton());
        add(new GeneralizationButton());
        add(new SelectButton());
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
        for (Component btn : getComponents()) {
            ((Button) btn).setWhite();
        }
    }
}
