package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mockConstruction;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedConstruction;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    @Test
    public void testMain() {
        // Arrange
        try (MockedConstruction<MainFrame> mockedMainFrameConstruction = mockConstruction(MainFrame.class)) {

            // Act
            App.main(null);

            // Assert
            List<MainFrame> constructedMainFrameList = mockedMainFrameConstruction.constructed();
            assertEquals(1, constructedMainFrameList.size());
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
