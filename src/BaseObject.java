
public class BaseObject extends AllObject {

    final int WIDTH = 110;
    final int HEIGHT = 110;

    BaseObject(int x, int y) {
        setBounds(x, y, WIDTH, HEIGHT);
        add(new Port(0, HEIGHT / 2));
        add(new Port(WIDTH / 2, 0));
        add(new Port(WIDTH / 2, HEIGHT - Port.HEIGHT));
        add(new Port(WIDTH - Port.WIDTH, HEIGHT / 2));
    }

}
