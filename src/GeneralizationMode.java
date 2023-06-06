public class GeneralizationMode extends ConnectionLineMode {
    @Override
    public void setClass() {
        obj = new GeneralizationLine(X, Y, startObject, endObject, startPort, endPort);
    }
}
