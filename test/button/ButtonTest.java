package button;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.awt.Color;
import java.net.URL;

class TestButton extends Button {
    public URL testGetResource(String fileName) {
        return getResource(fileName);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class ButtonTest {

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
