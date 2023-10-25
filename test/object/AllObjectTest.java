package object;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class AllObjectTest {
    private ConcreteAllObject concreteAllObject;

    @Before
    public void setUp() {
        concreteAllObject = new ConcreteAllObject();
    }

    @Test
    public void testConstructor() {
        assertNull(concreteAllObject.getLayout());
        assertFalse(concreteAllObject.isOpaque());
    }
}