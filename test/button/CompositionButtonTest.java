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
import mode.CompositionMode;

@RunWith(MockitoJUnitRunner.class)
public class CompositionButtonTest {

    @Mock
    Canvas mockCanvasInstance;

    @Captor
    ArgumentCaptor<CompositionMode> compositionModeCaptor;

    @Test
    public void testConstructor() {
        // Arrange
        try (MockedConstruction<ImageIcon> mockedImageIconConstruction = mockConstruction(
                ImageIcon.class)) {

            // Act
            CompositionButton testingCompositionButton = new CompositionButton();

            // Assert
            List<ImageIcon> constructedImageIconList = mockedImageIconConstruction.constructed();
            assertEquals(1, constructedImageIconList.size());

            assertSame(constructedImageIconList.get(0), testingCompositionButton.getIcon());
            assertEquals("Composition", testingCompositionButton.getText());
        }
    }

    @Test
    public void testSetMode() {
        // Arrange
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            try (MockedConstruction<CompositionMode> mockedCompositionModeConstruction = mockConstruction(
                    CompositionMode.class)) {
                CompositionButton testingCompositionButton = new CompositionButton();

                // Act
                testingCompositionButton.setMode();

                // Assert
                List<CompositionMode> constructedCompositionModeList = mockedCompositionModeConstruction.constructed();
                assertEquals(1, constructedCompositionModeList.size());

                verify(mockCanvasInstance, times(1)).setMode(compositionModeCaptor.capture());
                CompositionMode resultCompositionMode = compositionModeCaptor.getValue();
                CompositionMode expectCompositionMode = constructedCompositionModeList.get(0);
                assertSame(expectCompositionMode, resultCompositionMode);
            }
        }
    }
}
