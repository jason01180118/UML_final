import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    MainFrame() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        add(Canvas.getInstance());
        add(ButtonMenu.getInstance(), BorderLayout.WEST);
        add(new ToolMenu(), BorderLayout.NORTH);
        setTitle("project");
        setVisible(true);
    }

}
