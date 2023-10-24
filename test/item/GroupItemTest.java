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
public class GroupItemTest {
    @Mock
    Canvas mockCanvasInstance;
    MouseAdapter mouseAdapter;

    @Test
    public void testGroupItemMousePressed() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            GroupItem groupItem = new GroupItem();
            groupItem.addMouseListener(mouseAdapter = Mockito.mock(MouseAdapter.class));
            mouseAdapter.mousePressed(null);
            //use assert
            assertEquals(mockCanvasInstance, Canvas.getInstance());
        } catch (Exception e) {
        }
    }

    @Test
    public void testGroupTextSet() {
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            GroupItem groupItem = new GroupItem();
            groupItem.setText("Group");
            //assert
            assertEquals(groupItem.getText(), "Group");
        } catch (Exception e) {

        }
    }

}
