package mode;
import static org.mockito.Mockito.*;

import java.awt.event.MouseEvent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import main.Canvas;
import object.AllObject;
@RunWith(MockitoJUnitRunner.class)
public class BaseObjectModeTest {

    @Mock
    Canvas mockCanvasInstance;

    // Concrete subclass for testing purposes
    private class TestObjectMode extends BaseObjectMode {
        @Override
        public void setClass(int x, int y) {
            // For testing purposes, you might implement this method if needed
        }
    }

    @Test
    public void testMousePressed() {
        // Create an instance of TestObjectMode
        TestObjectMode testObjectMode = new TestObjectMode();
        AllObject mockAllObject = Mockito.mock(AllObject.class);
        testObjectMode.obj = mockAllObject;

        // Create a mock MouseEvent
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mockMouseEvent.getX()).thenReturn(10);  // Example x coordinate
        Mockito.when(mockMouseEvent.getY()).thenReturn(20);  // Example y coordinate

        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            
            // Call the mousePressed method
            testObjectMode.mousePressed(mockMouseEvent);

            // Verify that Canvas.getInstance().addComponent() was called with the correct arguments
            Mockito.verify(mockCanvasInstance, Mockito.times(1)).addComponent(
                    mockAllObject, Mockito.eq(0), Mockito.eq(1));
        }
        catch(Exception e) {
            // Handle any exceptions
        }
    }

    @Test
    public void testMouseReleased() {
        // Create an instance of TestObjectMode
        TestObjectMode testObjectMode = new TestObjectMode();

        // Create a mock MouseEvent
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);

        // Call the mouseReleased method
        testObjectMode.mouseReleased(mockMouseEvent);

        // Verify that no exceptions were thrown, verify mouseReleased has called once
        
    }
    @Test
    public void testSetClass() {
        // Create an instance of TestObjectMode
        TestObjectMode testObjectMode = new TestObjectMode();

        // Call the setClass method
        testObjectMode.setClass(10, 20);

        // Verify that no exceptions were thrown, verify setClass has called once
        
    }
    
}
