package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleTest {
    @Test
    public void testSomeMethod() {
        assertEquals(add(1, 1), 2);
        assertEquals(add(2, 3), 5);
    }

    private int add(int a, int b) {
        return a + b;
    }
}