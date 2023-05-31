public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Canvas.getInstance().printTest();
        Canvas.getInstance().setMode(new Mode());
        new MainFrame();
    }
}
