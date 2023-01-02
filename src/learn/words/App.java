package learn.words;

import learn.words.dialogs.Dialog;
import learn.words.dialogs.MainDialog;

public class App {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Dialog mainDialog = new MainDialog("Слова бегом");
            mainDialog.renderWindow();
        });
    }
}
