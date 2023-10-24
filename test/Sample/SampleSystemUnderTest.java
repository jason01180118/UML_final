package Sample;
public class SampleSystemUnderTest {
    private SampleDependedOnClass dependedOnClass;
    public void setSampleDependedOnClass(SampleDependedOnClass dependedOnClass) {
        this.dependedOnClass = dependedOnClass;
    }
    public void run() {
        System.out.println(dependedOnClass.doSomething() + "call by test class");
        System.out.println(dependedOnClass.doSomethingTwo() + "call by test class");
    }
}