package Main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ToolMenu extends JMenuBar {

    ToolMenu() {
        super();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Edit");
        add(m1);
        add(m2);
        m2.add(new GroupItem());
        m2.add(new UnGroupItem());
        m2.add(new SetNameItem());

    }

}
