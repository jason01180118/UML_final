package Mode;

import Object.CompositionLine;

public class CompositionMode extends ConnectionLineMode {
    @Override
    public void setClass() {
        obj = new CompositionLine(startObject, endObject, startPort, endPort);
    }
}
