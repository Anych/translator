package learn.words.view.option.buttonoption;

import learn.words.view.option.AbstractGridOptions;

public class ButtonWithImageOptions extends AbstractGridOptions {
    private final String imagePath;

    public ButtonWithImageOptions(int gridX, int gridY, String imagePath) {
        super(gridX, gridY);
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imagePath;
    }
}
