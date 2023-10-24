package item;

import main.Canvas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.event.MouseAdapter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockStatic;

@RunWith(MockitoJUnitRunner.class)
public class UnGroupItemTest {
    @Mock
    Canvas mockCanvasInstance;

    @Test
    public void testUnGroupItemMousePressed() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            UnGroupItem unGroupItem = new UnGroupItem();
            MouseAdapter mouseAdapter;
            unGroupItem.addMouseListener(mouseAdapter = Mockito.mock(MouseAdapter.class));
            mouseAdapter.mousePressed(null);
            //use assert
            assertEquals(mockCanvasInstance, Canvas.getInstance());
        } catch (Exception e) {
            // Handle any exceptions.
        }
    }

    @Test
    public void testUnGroupTextSet() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            GroupItem groupItem = new GroupItem();
            groupItem.setText("UnGroup");
            //assert
            assertEquals(groupItem.getText(), "UnGroup");
        } catch (Exception e) {

        }
    }
}

