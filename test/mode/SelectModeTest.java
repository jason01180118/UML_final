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
import org.springframework.test.util.ReflectionTestUtils;

import main.Canvas;
import object.AllObject;
import object.Classes;
import object.Port;
@RunWith(MockitoJUnitRunner.class)
public class SelectModeTest {

    @Mock
    Canvas mockCanvasInstance;

    @Mock
    AllObject mockAllObject;
    AllObject mockClassObject = new Classes(10, 20);
    

    @Mock
    Port mockPort;

    @Test
    public void testMousePressed() {
        SelectMode selectMode = new SelectMode();
        // Set up a mock MouseEvent with specific coordinates
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);
        Point mockPoint = new Point(10, 20);
        Mockito.when(mockMouseEvent.getPoint()).thenReturn(mockPoint);
        try(MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            Mockito.when(mockCanvasInstance.getObjectAt(mockPoint)).thenReturn(mockClassObject);

            // Call mousePressed()
            // selectMode.mousePressed(mockMouseEvent);
            System.out.println(Canvas.getInstance().getObjectAt(mockPoint));
            selectMode.mousePressed(mockMouseEvent);
            
            // Verify that startObject and startPort are correctly set
            assertEquals(mockClassObject, ReflectionTestUtils.getField(selectMode, "obj"));
            assertEquals(mockPoint, ReflectionTestUtils.getField(selectMode, "startPoint"));
            assertEquals(mockPoint, ReflectionTestUtils.getField(selectMode, "buffer"));
            // check if selectMode.obj.selected is true
            AllObject obj = (AllObject) ReflectionTestUtils.getField(selectMode, "obj");
            assertEquals(true, ReflectionTestUtils.getField(obj, "selected"));
            
            }
            
    }

    @Test
    public void testMousePressedNull() {
        SelectMode selectMode = new SelectMode();
        // Set up a mock MouseEvent with specific coordinates
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);
        Point mockPoint = new Point(10, 20);
        Mockito.when(mockMouseEvent.getPoint()).thenReturn(mockPoint);
        try(MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            Mockito.when(mockCanvasInstance.getObjectAt(mockPoint)).thenReturn(null);

            // Call mousePressed()
            // selectMode.mousePressed(mockMouseEvent);
            selectMode.mousePressed(mockMouseEvent);
            
            // Verify that startObject and startPort are correctly set
            assertEquals(null, ReflectionTestUtils.getField(selectMode, "obj"));
            assertEquals(mockPoint, ReflectionTestUtils.getField(selectMode, "startPoint"));
            assertEquals(mockPoint, ReflectionTestUtils.getField(selectMode, "buffer"));
            // check if selectMode.obj.selected is true
            
            }
            
    }

    @Test
    public void testMouseDragged() {
        SelectMode selectMode = new SelectMode();

        // Set up startPoint and buffer to simulate a previous mousePressed call
        Point startPoint = new Point(10, 10);
        ReflectionTestUtils.setField(selectMode, "startPoint", startPoint);
        ReflectionTestUtils.setField(selectMode, "buffer", startPoint);

        // Set up a mock MouseEvent with a specific point
        Point mockPoint = new Point(20, 30);
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mockMouseEvent.getPoint()).thenReturn(mockPoint);

        // Mock Canvas.getInstance().countSelected() to return non-zero
        Canvas mockCanvasInstance = mock(Canvas.class);
        Mockito.when(mockCanvasInstance.countSelected()).thenReturn(1);
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);

            // Call mouseDragged()
            selectMode.mouseDragged(mockMouseEvent);

            // Verify that moveSelectedObj() is called with the correct arguments
            verify(mockCanvasInstance, times(1)).moveSelectedObj(10, 20);

            // Verify that buffer is correctly updated
            assertEquals(mockPoint, ReflectionTestUtils.getField(selectMode, "buffer"));
        }
    }

    @Test
    public void testMouseReleased() {
        SelectMode selectMode = new SelectMode();

        // Set up startPoint to simulate a previous mousePressed call
        Point startPoint = new Point(10, 10);
        ReflectionTestUtils.setField(selectMode, "startPoint", startPoint);

        // Set up a mock MouseEvent with a specific point
        Point mockPoint = new Point(20, 30);
        MouseEvent mockMouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mockMouseEvent.getPoint()).thenReturn(mockPoint);

        // Mock Canvas.getInstance().countSelected() to return zero
        Canvas mockCanvasInstance = mock(Canvas.class);
        Mockito.when(mockCanvasInstance.countSelected()).thenReturn(0);
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);

            // Call mouseReleased()
            selectMode.mouseReleased(mockMouseEvent);

            // Verify that setSelectArea() is called with the correct arguments
            verify(mockCanvasInstance, times(1)).setSelectArea(startPoint, mockPoint);
        }
    }



}
