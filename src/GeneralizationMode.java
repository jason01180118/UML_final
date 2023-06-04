public class GeneralizationMode extends ConnectionLineMode {
    @Override
    public void setClass(int startX, int startY, int endX, int endY) {
        obj = new GeneralizationLine(startX, startY, endX, endY);
    }
}
