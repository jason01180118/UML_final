package object;

import main.Canvas;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.Component;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CompositeTest {
    private final int x = 100;
    private final int y = 50;
    private Composite composite;

    @Mock
    private Canvas mockCanvas;

    @Before
    public void setUp() {
        composite = Mockito.spy(new Composite());
        composite.x = x;
        composite.y = y;
        int componentNumber = 3;
        Component[] components = new Component[componentNumber];
        for (int i = 0; i < componentNumber; i++) {
            components[i] = Mockito.spy(new ConcreteAllObject());
        }
        when(composite.getComponents()).thenReturn(components);
    }

    @Test
    public void testSetSelect() {
        composite.setSelect();
        assertTrue(composite.selected);
        verify(composite, times(1)).setBorder(any());
    }

    @Test
    public void testSetUnSelect() {
        composite.setUnSelect();
        assertFalse(composite.selected);
        verify(composite, times(1)).setBorder(null);
    }

    @Test
    public void testMoveXY() {
        int offsetX = 30, offsetY = -20;
        composite.moveXY(offsetX, offsetY);
        assertEquals(composite.x, x + offsetX);
        assertEquals(composite.y, y + offsetY);
        verify(composite, times(1)).changeAbsoluteXY(offsetX, offsetY);
        verify(composite, times(1)).setLocation(composite.x, composite.y);
    }

    @Test
    public void testChangeXY() {
        int changeX = 30, changeY = -20;
        composite.changeXY(changeX, changeY);
        assertEquals(composite.x, changeX);
        assertEquals(composite.y, changeY);
        verify(composite, times(1)).setLocation(composite.x, composite.y);
    }

    @Test
    public void testChangeAbsoluteXY() {
        int offsetX = 30, offsetY = -20;
        composite.changeAbsoluteXY(offsetX, offsetY);
        for (Component component : composite.getComponents()) {
            verify((AllObject) component, times(1)).changeAbsoluteXY(offsetX, offsetY);
        }
    }

    @Test
    public void testSetXY() {
        composite.setXY();
        verify(composite, times(1)).setBounds(anyInt(), anyInt(), anyInt(), anyInt());
        for (Component component : composite.getComponents()) {
            verify((AllObject) component, times(1)).changeXY(anyInt(), anyInt());
        }
        verify(composite, times(1)).repaint();
    }

    @Test
    public void testRepaintLine() {
        composite.repaintLine();
        for (Component component : composite.getComponents()) {
            verify((AllObject) component, times(1)).repaintLine();
        }
    }

    @Test
    public void testSetUnGroup() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvas);
            assertTrue(composite.setUnGroup());
            for (Component component : composite.getComponents()) {
                verify((AllObject) component, times(1)).changeXY(component.getX() + x, component.getY() + y);
                verify(mockCanvas, times(1)).addComponent((AllObject) component, 0, 1);
            }
        }
    }
}