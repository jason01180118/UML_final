public class CompositionMode extends ConnectionLineMode {
    @Override
    public void setClass() {
        obj = new CompositionLine(X, Y, startObject, endObject, startPort, endPort);
    }
}
