package learn.words.view.option;

import learn.words.controller.action.learnwindowactions.WordsOnTextFields;
import learn.words.view.window.AbstractWindowBuilder;
import learn.words.view.window.TranslateWordWindow;

import javax.swing.*;

public class GridButtonOptions extends AbstractGridOptions {
    private final String action;
    private final String buttonName;
    private AbstractWindowBuilder newFrame;
    private JFrame frame;
    private JTextField inputTextField;
    private JTextField disabledTextField;
    private TranslateWordWindow translateWordWindow;
    private WordsOnTextFields wordsOnTextFields;
    private Thread thread;
    public GridButtonOptions(AbstractWindowBuilder newFrame, JFrame frame,
                             String buttonName, int gridX, int gridY) {
        super(gridX, gridY);
        this.action = "NewWindow";
        this.newFrame = newFrame;
        this.frame = frame;
        this.buttonName = buttonName;
    }

    public GridButtonOptions(TranslateWordWindow translateWordWindow, JTextField disabledTextField,
                             String buttonName, int gridX, int gridY) {
        super(gridX, gridY);
        this.action = "ChangeTranslation";
        this.buttonName = buttonName;
        this.translateWordWindow = translateWordWindow;
        this.disabledTextField = disabledTextField;
    }

    public GridButtonOptions(TranslateWordWindow translateWordWindow, JTextField inputTextField,
                             JTextField disabledTextField, String buttonName, int gridX, int gridY) {
        super(gridX, gridY);
        this.action = buttonName;
        this.buttonName = buttonName;
        this.translateWordWindow = translateWordWindow;
        this.inputTextField = inputTextField;
        this.disabledTextField = disabledTextField;
    }

    public GridButtonOptions(Thread thread, WordsOnTextFields wordsOnTextFields, String action, int gridX, int gridY) {
        super(gridX, gridY);
        this.thread = thread;
        this.buttonName = action;
        this.wordsOnTextFields = wordsOnTextFields;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public AbstractWindowBuilder getNewFrame() {
        return newFrame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getButtonName() {
        return buttonName;
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }

    public JTextField getDisabledTextField() {
        return disabledTextField;
    }

    public TranslateWordWindow getTranslateWordWindow() {
        return translateWordWindow;
    }

    public WordsOnTextFields getWordsOnTextFields() {
        return wordsOnTextFields;
    }

    public void setWordsOnTextFields(WordsOnTextFields wordsOnTextFields) {
        this.wordsOnTextFields = wordsOnTextFields;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
