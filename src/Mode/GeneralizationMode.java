package mode;

import object.GeneralizationLine;

public class GeneralizationMode extends ConnectionLineMode {
    @Override
    public void setClass() {
        obj = new GeneralizationLine(startObject, endObject, startPort, endPort);
    }
}
