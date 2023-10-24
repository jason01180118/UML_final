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
import mode.GeneralizationMode;

@RunWith(MockitoJUnitRunner.class)
public class GeneralizationButtonTest {

    @Mock
    Canvas mockCanvasInstance;

    @Captor
    ArgumentCaptor<GeneralizationMode> generalizationModeCaptor;

    @Test
    public void testConstructor() {
        // Arrange
        try (MockedConstruction<ImageIcon> mockedImageIconConstruction = mockConstruction(
                ImageIcon.class)) {

            // Act
            GeneralizationButton testingGeneralizationButton = new GeneralizationButton();

            // Assert
            List<ImageIcon> constructedImageIconList = mockedImageIconConstruction.constructed();
            assertEquals(1, constructedImageIconList.size());

            assertSame(constructedImageIconList.get(0), testingGeneralizationButton.getIcon());
            assertEquals("Generalization", testingGeneralizationButton.getText());
        }
    }

    @Test
    public void testSetMode() {
        // Arrange
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            try (MockedConstruction<GeneralizationMode> mockedGeneralizationModeConstruction = mockConstruction(
                    GeneralizationMode.class)) {
                GeneralizationButton testingGeneralizationButton = new GeneralizationButton();

                // Act
                testingGeneralizationButton.setMode();

                // Assert
                List<GeneralizationMode> constructedGeneralizationModeList = mockedGeneralizationModeConstruction.constructed();
                assertEquals(1, constructedGeneralizationModeList.size());

                verify(mockCanvasInstance, times(1)).setMode(generalizationModeCaptor.capture());
                GeneralizationMode resultGeneralizationMode = generalizationModeCaptor.getValue();
                GeneralizationMode expectGeneralizationMode = constructedGeneralizationModeList.get(0);
                assertSame(expectGeneralizationMode, resultGeneralizationMode);
            }
        }
    }
}
