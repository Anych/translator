package learn.words;

import learn.words.view.window.AbstractWindow;
import learn.words.view.window.MainWindow;

public class App {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AbstractWindow mainWindow = new MainWindow();
            mainWindow.renderWindow(false);
            mainWindow.createElements();
        });
    }
}
