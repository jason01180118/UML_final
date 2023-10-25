package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainFrameTest {
    @Test
    public void testConstructor() {
        // Arrange
        // Act
        MainFrame testMainFrame = new MainFrame();
        // Assert
        assertEquals(JFrame.EXIT_ON_CLOSE, testMainFrame.getDefaultCloseOperation());
        assertEquals(new Rectangle(100, 100, 1200, 600), testMainFrame.getBounds());
        List<Component> components = Arrays.asList(testMainFrame.getContentPane().getComponents());
        assertTrue(components.stream().anyMatch(component -> component instanceof Canvas));
        assertTrue(components.stream().anyMatch(component -> component instanceof ButtonMenu));
        assertTrue(components.stream().anyMatch(component -> component instanceof ToolMenu));
        assertEquals(true, testMainFrame.isVisible());
    }
}
