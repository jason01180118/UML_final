package mode;

import object.Classes;

public class ClassMode extends BaseObjectMode {
    public ClassMode() {

    }

    @Override
    public void setClass(int x, int y) {
        obj = new Classes(x, y);
    }

}
