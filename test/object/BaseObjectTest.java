package object;

import main.Canvas;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
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
        concreteBaseObject = Mockito.spy(new ConcreteBaseObject(x, y));
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
        int offsetX = 30, offsetY = -20;
        concreteBaseObject.moveXY(offsetX, offsetY);
        assertEquals(concreteBaseObject.x, x + offsetX);
        assertEquals(concreteBaseObject.y, y + offsetY);
        verify(concreteBaseObject, times(1)).changeAbsoluteXY(offsetX, offsetY);
        verify(concreteBaseObject, times(1)).setLocation(concreteBaseObject.x, concreteBaseObject.y);
    }

    @Test
    public void testChangeXY() {
        int changeX = 30, changeY = -20;
        concreteBaseObject.changeXY(changeX, changeY);
        assertEquals(concreteBaseObject.x, changeX);
        assertEquals(concreteBaseObject.y, changeY);
        verify(concreteBaseObject, times(1)).setLocation(changeX, changeY);
    }

    @Test
    public void testChangeAbsoluteXY() {
        int offsetX = 30, offsetY = -20;
        concreteBaseObject.changeAbsoluteXY(offsetX, offsetY);
        assertEquals(concreteBaseObject.absoluteX, x + offsetX);
        assertEquals(concreteBaseObject.absoluteY, y + offsetY);
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