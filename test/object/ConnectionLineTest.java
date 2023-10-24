package object;

import main.Canvas;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

class ConcreteConnectionLine extends ConnectionLine {
    ConcreteConnectionLine(AllObject startObject, AllObject endObject, Port startPort, Port endPort) {
        super(startObject, endObject, startPort, endPort);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class ConnectionLineTest {
    private ConnectionLine connectionLine;

    @Before
    public void setUp() {
        connectionLine = new ConcreteConnectionLine(startObject, endObject, startPort, endPort);
    }

    @Mock
    AllObject startObject = mock(AllObject.class);
    AllObject endObject = mock(AllObject.class);
    Port startPort = mock(Port.class);
    Port endPort = mock(Port.class);

    @Test
    public void testSetXY() {
        // TODO: waiting for issue fixing
    }

    @Test
    public void testIsRelated() {
        assertTrue(connectionLine.isRelated(startObject));
        assertTrue(connectionLine.isRelated(endObject));
        AllObject otherObject = mock(AllObject.class);
        assertFalse(connectionLine.isRelated(otherObject));
    }
}