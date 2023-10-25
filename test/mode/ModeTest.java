package mode;
import org.junit.Test;

public class ModeTest {

    @Test
    public void testMouseDragged() {
        Mode mode = new Mode() {
        };

        mode.mouseDragged(null);
    }

    @Test
    public void testMouseClicked() {
        Mode mode = new Mode() {
        };

        mode.mouseClicked(null);
    }

    @Test
    public void testMousePressed() {
        Mode mode = new Mode() {
        };

        mode.mousePressed(null);
    }

    @Test
    public void testMouseReleased() {
        Mode mode = new Mode() {
        };

        mode.mouseReleased(null);
    }
}
