package test;
import org.junit.Test;
import org.mockito.Mockito;

public class SampleTestSpy {
    SampleSystemUnderTest sut = new SampleSystemUnderTest();

    @Test
    public void testSutBySpy() {
        SampleDependedOnClass dependedOnClass = Mockito.spy(new SampleDependedOnClass());
        sut.setSampleDependedOnClass(dependedOnClass);
        Mockito.when(dependedOnClass.doSomething()).thenReturn("Mock class ");
        sut.run();
    }
}