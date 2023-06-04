public class ClassMode extends BaseObjectMode {
    ClassMode() {

    }

    @Override
    public void setClass(int x, int y) {
        obj = new Classes(x, y);
    }

}
