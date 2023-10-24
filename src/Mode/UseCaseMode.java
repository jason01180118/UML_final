package mode;

import object.UseCase;

public class UseCaseMode extends BaseObjectMode {
    @Override
    public void setClass(int x, int y) {
        obj = new UseCase(x, y);
    }
}
