package mode;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Point;
import java.awt.event.MouseEvent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import main.Canvas;
import object.AllObject;
import object.Classes;
import object.Port;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionLineModeTest {

    @Mock
    Canvas mockCanvasInstance;

    @Mock
    AllObject mockAllObject;
    AllObject mockClassObject = new Classes(10, 20);
    

    @Mock
    Port mockPort;

    @Test
    public void testMousePressed() {
        ConnectionLineMode connectionLineMode = new ConnectionLineMode();
        
        // Set up a mock MouseEvent with specific coordinates
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);
        Point mockPoint = new Point(10, 20);
        Mockito.when(mockMouseEvent.getPoint()).thenReturn(mockPoint);
        try(MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            Mockito.when(mockCanvasInstance.getObjectAt(mockPoint)).thenReturn(mockClassObject);
            Mockito.when(mockAllObject.getPort(mockPoint)).thenReturn(mockPort);

            // Call mousePressed()
            connectionLineMode.mousePressed(mockMouseEvent);
            // Verify that startObject and startPort are correctly set
            assertEquals(mockClassObject, connectionLineMode.startObject);
            assertEquals(mockClassObject.getPort(mockMouseEvent.getPoint()), connectionLineMode.startPort);
            }
            
        }

    @Test
    public void testMouseReleased() {
        ConnectionLineMode connectionLineMode = new ConnectionLineMode();
        
        // Set up a mock MouseEvent with specific coordinates
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);
        Point mockPoint = new Point(20, 20);
        Mockito.when(mockMouseEvent.getPoint()).thenReturn(mockPoint);
        try(MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            Mockito.when(mockCanvasInstance.getObjectAt(mockPoint)).thenReturn(mockClassObject);
            Mockito.when(mockAllObject.getPort(mockPoint)).thenReturn(mockPort);

            // Act
            connectionLineMode.mouseReleased(mockMouseEvent);
            // Verify that startObject and startPort are correctly set
            assertEquals(null, connectionLineMode.endObject);
            assertEquals(null, connectionLineMode.endPort);
            }
            
        }
}
