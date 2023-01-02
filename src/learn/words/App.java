package learn.words;

import learn.words.dialogs.AbstractDialog;
import learn.words.dialogs.MainDialog;

public class App {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AbstractDialog mainAbstractDialog = new MainDialog();
            mainAbstractDialog.renderWindow();
        });
    }
}
