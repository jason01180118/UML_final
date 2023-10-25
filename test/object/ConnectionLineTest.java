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

class ConcreteConnectionLine extends ConnectionLine {
    ConcreteConnectionLine(AllObject startObject, AllObject endObject, Port startPort, Port endPort) {
        super(startObject, endObject, startPort, endPort);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class ConnectionLineTest {
    private ConcreteConnectionLine concreteConnectionLine;

    @Mock
    private Canvas mockCanvas;
    private final AllObject startObject = mock(AllObject.class);
    private final AllObject endObject = mock(AllObject.class);
    private final Port startPort = mock(Port.class);
    private final Port endPort = mock(Port.class);

    @Before
    public void setUp() {
        concreteConnectionLine = Mockito.spy(new ConcreteConnectionLine(startObject, endObject, startPort, endPort));
    }

    @Test
    public void testConstructor() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvas);
            assertEquals(concreteConnectionLine.getBounds(),
                    new Rectangle(0, 0, mockCanvas.getWidth(), mockCanvas.getHeight()));
        }
    }

    @Test
    public void testSetXY() {
        startObject.absoluteX = 20;
        startObject.absoluteY = 35;
        endObject.absoluteX = 60;
        endObject.absoluteY = 75;
        when(startPort.getX()).thenReturn(80);
        when(startPort.getY()).thenReturn(70);
        when(endPort.getX()).thenReturn(60);
        when(endPort.getY()).thenReturn(50);
        concreteConnectionLine.setXY();
        assertEquals(concreteConnectionLine.startX, 100);
        assertEquals(concreteConnectionLine.startY, 105);
        assertEquals(concreteConnectionLine.endX, 120);
        assertEquals(concreteConnectionLine.endY, 125);
        verify(concreteConnectionLine, times(1)).repaint();
    }

    @Test
    public void testIsRelated() {
        assertTrue(concreteConnectionLine.isRelated(startObject));
        assertTrue(concreteConnectionLine.isRelated(endObject));
        AllObject otherObject = mock(AllObject.class);
        assertFalse(concreteConnectionLine.isRelated(otherObject));
    }
}