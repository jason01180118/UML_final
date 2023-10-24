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
import mode.AssociationMode;

@RunWith(MockitoJUnitRunner.class)
public class AssociationButtonTest {

    @Mock
    Canvas mockCanvasInstance;

    @Captor
    ArgumentCaptor<AssociationMode> associationModeCaptor;

    @Test
    public void testConstructor() {
        // Arrange
        try (MockedConstruction<ImageIcon> mockedImageIconConstruction = mockConstruction(
                ImageIcon.class)) {

            // Act
            AssociationButton testingAssociationButton = new AssociationButton();

            // Assert
            List<ImageIcon> constructedImageIconList = mockedImageIconConstruction.constructed();
            assertEquals(1, constructedImageIconList.size());

            assertSame(constructedImageIconList.get(0), testingAssociationButton.getIcon());
            assertEquals("AssociationButton", testingAssociationButton.getText());
        }
    }

    @Test
    public void testSetMode() {
        // Arrange
        try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
            mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
            try (MockedConstruction<AssociationMode> mockedAssociationModeConstruction = mockConstruction(
                    AssociationMode.class)) {
                AssociationButton testingAssociationButton = new AssociationButton();

                // Act
                testingAssociationButton.setMode();

                // Assert
                List<AssociationMode> constructedAssociationModeList = mockedAssociationModeConstruction.constructed();
                assertEquals(1, constructedAssociationModeList.size());

                verify(mockCanvasInstance, times(1)).setMode(associationModeCaptor.capture());
                AssociationMode resultAssociationMode = associationModeCaptor.getValue();
                AssociationMode expectAssociationMode = constructedAssociationModeList.get(0);
                assertSame(expectAssociationMode, resultAssociationMode);
            }
        }
    }
}
