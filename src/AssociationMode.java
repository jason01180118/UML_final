public class AssociationMode extends ConnectionLineMode {
    @Override
    public void setClass(int startX, int startY, int endX, int endY) {
        obj = new AssociationLine(startX, startY, endX, endY);
    }
}
