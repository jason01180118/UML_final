package mode;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import object.AllObject;
@RunWith(MockitoJUnitRunner.class)
public class ClassModeTest {

    @Mock
    AllObject mockAllObject;

    @Test
    public void testSetClass() {
        ClassMode classMode = new ClassMode();
        // Act
        classMode.setClass(10, 20);
        // Assert
        assertEquals(10, classMode.obj.getX());
        assertEquals(20, classMode.obj.getY());
    }
}

