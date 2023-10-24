package button;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import javax.swing.ImageIcon;
import main.Canvas;
import mode.SelectMode;

@RunWith(MockitoJUnitRunner.class)
public class SelectButtonTest {

    @Mock
    Canvas mockCanvasInstance;

    @Captor
    ArgumentCaptor<SelectMode> selectModeCaptor;

    @Test
    public void testConstructor() {
        // Arrange
        try (MockedConstruction<ImageIcon> mockedImageIconConstruction = mockConstruction(
                ImageIcon.class)) {

            // Act
            SelectButton testingSelectButton = new SelectButton();

            // Assert
            List<ImageIcon> constructedImageIconList = mockedImageIconConstruction.constructed();
            assertEquals(1, constructedImageIconList.size());

            assertSame(constructedImageIconList.get(0), testingSelectButton.getIcon());
            assertEquals("Select", testingSelectButton.getText());
        }
    }

    @Test
    public void testSetMode() {
        // Arrange
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            try (MockedConstruction<SelectMode> mockedSelectModeConstruction = mockConstruction(
                    SelectMode.class)) {
                SelectButton testingSelectButton = new SelectButton();

                // Act
                testingSelectButton.setMode();

                // Assert
                List<SelectMode> constructedSelectModeList = mockedSelectModeConstruction.constructed();
                assertEquals(1, constructedSelectModeList.size());

                verify(mockCanvasInstance, times(1)).setMode(selectModeCaptor.capture());
                SelectMode resultSelectMode = selectModeCaptor.getValue();
                SelectMode expectSelectMode = constructedSelectModeList.get(0);
                assertSame(expectSelectMode, resultSelectMode);
            }
        }
    }
}
