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
import mode.ClassMode;

@RunWith(MockitoJUnitRunner.class)
public class ClassButtonTest {

    @Mock
    Canvas mockCanvasInstance;

    @Captor
    ArgumentCaptor<ClassMode> classModeCaptor;

    @Test
    public void testConstructor() {
        // Arrange
        try (MockedConstruction<ImageIcon> mockedImageIconConstruction = mockConstruction(
                ImageIcon.class)) {

            // Act
            ClassButton testingClassButton = new ClassButton();

            // Assert
            List<ImageIcon> constructedImageIconList = mockedImageIconConstruction.constructed();
            assertEquals(1, constructedImageIconList.size());

            assertSame(constructedImageIconList.get(0), testingClassButton.getIcon());
            assertEquals("classes", testingClassButton.getText());
        }
    }

    @Test
    public void testSetMode() {
        // Arrange
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            try (MockedConstruction<ClassMode> mockedClassModeConstruction = mockConstruction(
                    ClassMode.class)) {
                ClassButton testingClassButton = new ClassButton();

                // Act
                testingClassButton.setMode();

                // Assert
                List<ClassMode> constructedClassModeList = mockedClassModeConstruction.constructed();
                assertEquals(1, constructedClassModeList.size());

                verify(mockCanvasInstance, times(1)).setMode(classModeCaptor.capture());
                ClassMode resultClassMode = classModeCaptor.getValue();
                ClassMode expectClassMode = constructedClassModeList.get(0);
                assertSame(expectClassMode, resultClassMode);
            }
        }
    }
}
