package learn.words.view.option;

public abstract class AbstractGridOptions {
    protected final int gridX;
    protected final int gridY;

    public AbstractGridOptions(int gridX, int gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }
}
