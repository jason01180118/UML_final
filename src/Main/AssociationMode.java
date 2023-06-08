package Main;

public class AssociationMode extends ConnectionLineMode {
    @Override
    public void setClass() {
        obj = new AssociationLine(startObject, endObject, startPort, endPort);
    }
}
