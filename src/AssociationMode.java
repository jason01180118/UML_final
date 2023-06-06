public class AssociationMode extends ConnectionLineMode {
    @Override
    public void setClass() {
        obj = new AssociationLine(X, Y, startObject, endObject, startPort, endPort);
    }
}
