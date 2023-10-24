package sample.item;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import item.SetNameItem;
import main.Canvas;
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
            try(MockedStatic<JOptionPane> mockOptionPane = mockStatic(JOptionPane.class)){

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
            try(MockedStatic<JOptionPane> mockOptionPane = mockStatic(JOptionPane.class)){

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
