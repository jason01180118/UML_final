public class CompositionMode extends ConnectionLineMode {
    @Override
    public void setClass(int startX, int startY, int endX, int endY) {
        obj = new CompositionLine(startX, startY, endX, endY);
    }
}
