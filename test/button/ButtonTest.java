package button;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;
import java.awt.Color;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

class TestButton extends Button {
    public URL testGetResource(String fileName) {
        return getResource(fileName);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class ButtonTest {
    @Test
    public void testConstructor() {
        try (MockedStatic<BorderFactory> mockedStaticBorderFactory = mockStatic(BorderFactory.class)) {
            Border mockBorder = mock(Border.class);
            mockedStaticBorderFactory.when(() -> BorderFactory.createLineBorder(Color.black)).thenReturn(mockBorder);
            // Arrange & Act
            TestButton testButton = new TestButton();

            // Assert
            assertEquals(true, testButton.isOpaque());
            assertEquals(mockBorder, testButton.getBorder());
            assertEquals(SwingConstants.CENTER, testButton.getHorizontalAlignment());
            assertEquals(SwingConstants.CENTER, testButton.getVerticalAlignment());
            assertEquals(SwingConstants.CENTER, testButton.getHorizontalTextPosition());
            assertEquals(SwingConstants.BOTTOM, testButton.getVerticalTextPosition());
            assertEquals(Color.WHITE, testButton.getBackground());
            assertEquals(Color.BLACK, testButton.getForeground());
        }
    }

    @Test
    public void testSetWhite() {
        // Arrange
        TestButton spyTestButton = spy(new TestButton());

        // Act
        spyTestButton.setWhite();

        // Assert
        verify(spyTestButton, times(1)).setBackground(Color.WHITE);
        verify(spyTestButton, times(1)).setForeground(Color.BLACK);
    }

    @Test
    public void testSetBlack() {
        // Arrange
        TestButton spyTestButton = spy(new TestButton());

        // Act
        spyTestButton.setBlack();

        // Assert
        verify(spyTestButton, times(1)).setBackground(Color.BLACK);
        verify(spyTestButton, times(1)).setForeground(Color.WHITE);
        verify(spyTestButton, atLeastOnce()).repaint();
    }

    @Test
    public void testSetMode() {
        // Arrange
        TestButton spyTestButton = spy(new TestButton());

        // Act
        spyTestButton.setMode();

        // Assert
        verify(spyTestButton, times(1)).setMode();
        verifyNoMoreInteractions(spyTestButton);
    }

    @Test
    public void testGetResource() {
        // Arrange
        TestButton spyTestButton = spy(new TestButton());

        // Act
        URL resultResource = spyTestButton.testGetResource("test_path");
        URL expectResource = TestButton.class.getResource("test_path");
        System.out.println(resultResource);
        // Assert
        assertEquals(expectResource, resultResource);
    }
}
