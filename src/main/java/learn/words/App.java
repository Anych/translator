package learn.words;

import learn.words.views.windows.AbstractWindow;
import learn.words.views.windows.MainWindow;

public class App {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AbstractWindow mainWindow = new MainWindow();
            mainWindow.renderWindow();
            mainWindow.createElements();
        });
    }
}
