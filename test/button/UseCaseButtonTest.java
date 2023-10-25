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
import mode.UseCaseMode;

@RunWith(MockitoJUnitRunner.class)
public class UseCaseButtonTest {

    @Mock
    Canvas mockCanvasInstance;

    @Captor
    ArgumentCaptor<UseCaseMode> useCaseModeCaptor;

    @Test
    public void testConstructor() {
        // Arrange
        try (MockedConstruction<ImageIcon> mockedImageIconConstruction = mockConstruction(
                ImageIcon.class)) {

            // Act
            UseCaseButton testingUseCaseButton = new UseCaseButton();

            // Assert
            List<ImageIcon> constructedImageIconList = mockedImageIconConstruction.constructed();
            assertEquals(1, constructedImageIconList.size());

            assertSame(constructedImageIconList.get(0), testingUseCaseButton.getIcon());
            assertEquals("UseCase", testingUseCaseButton.getText());
        }
    }

    @Test
    public void testSetMode() {
        // Arrange
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            try (MockedConstruction<UseCaseMode> mockedUseCaseModeConstruction = mockConstruction(
                    UseCaseMode.class)) {
                UseCaseButton testingUseCaseButton = new UseCaseButton();

                // Act
                testingUseCaseButton.setMode();

                // Assert
                List<UseCaseMode> constructedUseCaseModeList = mockedUseCaseModeConstruction.constructed();
                assertEquals(1, constructedUseCaseModeList.size());

                verify(mockCanvasInstance, times(1)).setMode(useCaseModeCaptor.capture());
                UseCaseMode resultUseCaseMode = useCaseModeCaptor.getValue();
                UseCaseMode expectUseCaseMode = constructedUseCaseModeList.get(0);
                assertSame(expectUseCaseMode, resultUseCaseMode);
            }
        }
    }
}
