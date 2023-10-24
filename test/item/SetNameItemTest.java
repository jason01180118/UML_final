package item;

import main.Canvas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.*;
import java.awt.event.MouseAdapter;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;

@RunWith(MockitoJUnitRunner.class)
public class SetNameItemTest {
    @Mock
    Canvas mockCanvasInstance;
    SetNameItem setNameItem = new SetNameItem();
    MouseAdapter mouseAdapter;
    JFrame mockFrame = Mockito.mock(JFrame.class);

    @Test
    public void testSetNameItemNotNull() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            try (MockedStatic<JOptionPane> mockOptionPane = mockStatic(JOptionPane.class)) {

                mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
                mockOptionPane.when(() -> JOptionPane.showInputDialog(any(null), "Enter your message")).thenReturn("NewName");

                setNameItem.addMouseListener(mouseAdapter = Mockito.mock(MouseAdapter.class));
                mouseAdapter.mousePressed(null);
                // verify(mockCanvasInstance, times(1)).changeName("NewName");

                //assert 
                assertEquals("NewName", mockCanvasInstance.getName());

            }
            mockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            // Handle any exceptions.
        }
    }

    @Test
    public void testSetNameItemNull() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            try (MockedStatic<JOptionPane> mockOptionPane = mockStatic(JOptionPane.class)) {

                mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
                mockOptionPane.when(() -> JOptionPane.showInputDialog(any(null), "Enter your message")).thenReturn(null);

                setNameItem.addMouseListener(mouseAdapter = Mockito.mock(MouseAdapter.class));
                mouseAdapter.mousePressed(null);
                // verify(mockCanvasInstance, times(1)).changeName("NewName");

                //assert 
                assertEquals(null, mockCanvasInstance.getName());

            }
            mockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            // Handle any exceptions.
        }
    }
}
