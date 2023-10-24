package object;

import main.Canvas;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

class ConcreteBaseObject extends BaseObject {
    ConcreteBaseObject(int x, int y) {
        super(x, y);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class BaseObjectTest {
    private final int x = 100;
    private final int y = 50;
    private ConcreteBaseObject concreteBaseObject;

    @Mock
    private Canvas mockCanvas;

    @Before
    public void setUp() {
        concreteBaseObject = new ConcreteBaseObject(x, y);
    }

    @Test
    public void testGetPortNotNull() {
        assertNotNull(concreteBaseObject.getPort(new Point(x, y)));
    }

    @Test
    public void testSetSelectOrUnSelect() {
        concreteBaseObject.setSelect();
        assertTrue(concreteBaseObject.selected);
        concreteBaseObject.setUnSelect();
        assertFalse(concreteBaseObject.selected);
    }

    @Test
    public void testMoveXY() {
        concreteBaseObject.moveXY(30, -20);
        assertEquals(concreteBaseObject.x, x + 30);
        assertEquals(concreteBaseObject.y, y - 20);
    }

    @Test
    public void testChangeXY() {
        concreteBaseObject.changeXY(30, -20);
        assertEquals(concreteBaseObject.x, 30);
        assertEquals(concreteBaseObject.y, -20);
    }

    @Test
    public void testChangeAbsoluteXY() {
        concreteBaseObject.changeAbsoluteXY(30, -20);
        assertEquals(concreteBaseObject.absoluteX, x + 30);
        assertEquals(concreteBaseObject.absoluteY, y - 20);
    }

    @Test
    public void testRepaintLine() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvas);
            concreteBaseObject.repaintLine();
            verify(mockCanvas, times(1)).repaintLine(concreteBaseObject);
        }
    }
}