package main;

import mode.Mode;
import object.AllObject;
import object.ConcreteAllObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CanvasTest {
    private final int componentNumber = 3;
    private Component[] components;

    @Mock
    private Canvas canvas;

    @Before
    public void setUp() {
        canvas = Mockito.spy(Canvas.getInstance());
        components = new Component[componentNumber];
        for (int i = 0; i < componentNumber; i++) {
            components[i] = Mockito.spy(new ConcreteAllObject());
        }
        when(canvas.getComponents()).thenReturn(components);
        when(canvas.getComponentsInLayer(anyInt())).thenReturn(components);
    }

    @Test
    public void testGetInstanceIsTheSame() {
        Canvas canvas1 = Canvas.getInstance();
        Canvas canvas2 = Canvas.getInstance();
        assertEquals(canvas1, canvas2);
    }

    @Test
    public void testSetMode() {
        Mode oldMode = canvas.mode;
        Mode newMode = mock(Mode.class);
        canvas.setMode(newMode);
        verify(canvas, times(1)).removeMouseListener(oldMode);
        verify(canvas, times(1)).removeMouseMotionListener(oldMode);
        verify(canvas, times(1)).addMouseListener(newMode);
        verify(canvas, times(1)).addMouseMotionListener(newMode);
    }

    @Test
    public void testAddComponent() {
        AllObject obj = new ConcreteAllObject();
        int order = 10, layer = 2;
        canvas.addComponent(obj, order, layer);
        verify(canvas, times(1)).add(obj, order);
        verify(canvas, times(1)).setLayer(obj, layer);
        verify(canvas, times(1)).repaint();
    }

    @Test
    public void testGetObjectAt() {
        for (Component component : components) {
            when(component.getBounds()).thenReturn(new Rectangle(50, 100, 20, 10));
        }
        assertNotNull(canvas.getObjectAt(new Point(50, 100)));
        assertNotNull(canvas.getObjectAt(new Point(60, 105)));
        assertNotNull(canvas.getObjectAt(new Point(70, 110)));
        assertNull(canvas.getObjectAt(new Point(40, 50)));
        assertNull(canvas.getObjectAt(new Point(120, 100)));
        assertNull(canvas.getObjectAt(new Point(50, 130)));
    }

    @Test
    public void testSetUnSelect() {
        canvas.setUnSelect();
        for (Component component : canvas.getComponentsInLayer(1)) {
            verify((AllObject) component, times(1)).setUnSelect();
        }
    }

    @Test
    public void testCountSelected() {
        for (int i = 0; i < componentNumber; i++) {
            ((AllObject) components[i]).selected = i > 0;
        }
        assertEquals(canvas.countSelected(), 2);
    }

    @Test
    public void testRepaintLine() {
        for (int i = 0; i < componentNumber; i++) {
            when(((AllObject) components[i]).isRelated(any())).thenReturn(i > 0);
        }
        canvas.repaintLine(mock(ConcreteAllObject.class));
        for (Component component : canvas.getComponentsInLayer(0)) {
            if (((AllObject) component).isRelated(any())) {
                verify((AllObject) component, times(1)).setXY();
            } else {
                verify((AllObject) component, times(0)).setXY();
            }
        }
    }

    @Test
    public void testGroupObjectWithTwoOrMoreSelected() {
        for (int i = 0; i < componentNumber; i++) {
            ((AllObject) components[i]).selected = i > 0;
        }
        when(canvas.countSelected()).thenReturn(2);
        canvas.groupObject();
        for (int i = 0; i < componentNumber; i++) {
            if (i > 0) {
                verify(((AllObject) components[i]), times(1)).setUnSelect();
                verify(canvas, times(1)).remove(components[i]);
            } else {
                verify(((AllObject) components[i]), times(0)).setUnSelect();
                verify(canvas, times(0)).remove(components[i]);
            }
        }
    }

    @Test
    public void testGroupObjectWithLessThanTwoSelected() {
        for (int i = 0; i < componentNumber; i++) {
            ((AllObject) components[i]).selected = i > 0;
        }
        when(canvas.countSelected()).thenReturn(1);
        canvas.groupObject();
        for (Component component : components) {
            verify(((AllObject) component), times(0)).setUnSelect();
            verify(canvas, times(0)).remove(component);
        }
    }

    @Test
    public void testUnGroupObjectWithOneSelected() {
        for (int i = 0; i < componentNumber; i++) {
            ((AllObject) components[i]).selected = i > 0;
            when(((AllObject) components[i]).setUnGroup()).thenReturn(i > 1);
        }
        when(canvas.countSelected()).thenReturn(1);
        canvas.unGroupObject();
        for (int i = 0; i < componentNumber; i++) {
            if (i > 0) {
                verify(((AllObject) components[i]), times(1)).setUnGroup();
                if (i > 1) {
                    verify(canvas, times(1)).remove(components[i]);
                } else {
                    verify(canvas, times(0)).remove(components[i]);
                }
            } else {
                verify(((AllObject) components[i]), times(0)).setUnSelect();
                verify(canvas, times(0)).remove(components[i]);
            }
        }
    }

    @Test
    public void testUnGroupObjectWithZeroSelected() {
        for (int i = 0; i < componentNumber; i++) {
            ((AllObject) components[i]).selected = i > 0;
        }
        when(canvas.countSelected()).thenReturn(0);
        canvas.unGroupObject();
        for (Component component : components) {
            verify(((AllObject) component), times(0)).setUnGroup();
            verify(canvas, times(0)).remove(component);
        }
    }

    @Test
    public void testChangeNameWithOneSelected() {
        for (int i = 0; i < componentNumber; i++) {
            ((AllObject) components[i]).selected = i > 0;
        }
        when(canvas.countSelected()).thenReturn(1);
        canvas.changeName("TEST");
        for (int i = 0; i < componentNumber; i++) {
            if (i > 0) {
                verify(((AllObject) components[i]), times(1)).changeName("TEST");
            } else {
                verify(((AllObject) components[i]), times(0)).changeName("TEST");
            }
        }
    }

    @Test
    public void testChangeNameWithZeroSelected() {
        for (int i = 0; i < componentNumber; i++) {
            ((AllObject) components[i]).selected = i > 0;
        }
        when(canvas.countSelected()).thenReturn(0);
        canvas.changeName("TEST");
        for (Component component : components) {
            verify(((AllObject) component), times(0)).changeName("TEST");
        }
    }
}