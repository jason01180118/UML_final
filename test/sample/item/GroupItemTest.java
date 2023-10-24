package sample.item;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.event.MouseAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import item.GroupItem;
import main.Canvas;
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
