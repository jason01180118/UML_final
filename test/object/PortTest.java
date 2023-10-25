package object;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class PortTest {
    private final int x = 40;
    private final int y = 30;
    private Port port;

    @Before
    public void setUp() {
        port = new Port(x, y);
    }

    @Test
    public void testConstructor() {
        assertEquals(port.getBounds(), new Rectangle(x, y, Port.WIDTH, Port.HEIGHT));
        assertFalse(port.isVisible());
    }
}