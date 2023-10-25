package mode;



import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import object.AllObject;
import object.CompositionLine;
import object.Port;
@RunWith(MockitoJUnitRunner.class)
public class CompositionModeTest {

    @Mock
    AllObject mockStartObject;

    @Mock
    AllObject mockEndObject;

    @Mock
    Port mockStartPort;

    @Mock
    Port mockEndPort;

    @Test
    public void testSetClass() {
        // Create an instance of CompositionMode
        CompositionMode compositionMode = new CompositionMode();

        // Set startObject, endObject, startPort, and endPort
        compositionMode.startObject = mockStartObject;
        compositionMode.endObject = mockEndObject;
        compositionMode.startPort = mockStartPort;
        compositionMode.endPort = mockEndPort;

        // Call setClass()
        compositionMode.setClass();

        // Verify that obj is set to a new CompositionLine
        CompositionLine expectedCompositionLine = new CompositionLine(mockStartObject, mockEndObject, mockStartPort, mockEndPort);
        
        assertEquals(expectedCompositionLine.toString(), compositionMode.obj.toString());
    }
}

