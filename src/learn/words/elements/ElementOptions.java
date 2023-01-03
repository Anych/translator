package learn.words.elements;

import java.awt.*;

public interface ElementOptions {
    void setOptions(Record options);
    void setRecordFields();
    void setGridX(int gridX);
    void setGridY(int gridY);
    void setConstraints(GridBagConstraints constraints);
}
