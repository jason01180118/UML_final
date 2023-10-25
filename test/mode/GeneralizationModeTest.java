package mode;



import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import object.AllObject;
import object.GeneralizationLine;
import object.Port;
@RunWith(MockitoJUnitRunner.class)
public class GeneralizationModeTest {

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
        GeneralizationMode generalizationMode = new GeneralizationMode();

        // Set startObject, endObject, startPort, and endPort
        generalizationMode.startObject = mockStartObject;
        generalizationMode.endObject = mockEndObject;
        generalizationMode.startPort = mockStartPort;
        generalizationMode.endPort = mockEndPort;

        // Call setClass()
        generalizationMode.setClass();

        // Verify that obj is set to a new CompositionLine
        GeneralizationLine expectedGeneralizationLine = new GeneralizationLine(mockStartObject, mockEndObject, mockStartPort, mockEndPort);
        
        assertEquals(expectedGeneralizationLine.toString(), generalizationMode.obj.toString());
    }
}

